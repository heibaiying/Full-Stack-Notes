# PXC 集群搭建

<nav>
<a href="#一PXC-集群">一、PXC 集群</a><br/>
<a href="#二集群搭建">二、集群搭建</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-准备安装">2.1 准备安装</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22--在线安装">2.2  在线安装</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-修改密码">2.3 修改密码</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-搭建集群">2.4 搭建集群</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#25-启动集群">2.5 启动集群</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#26-节点下线">2.6 节点下线</a><br/>
</nav>

## 一、PXC 集群

Percona XtraDB Cluster (简称 PXC) 是 Percona 公司开源的实现 MySQL 高可用的解决方案。它将 Percona Server 和 Percona XtraBackup 与 Galera 库集成，以实现多主同步复制。和 MySQL 传统的异步复制相比，它能够保证数据的强一致性，在任何时刻集群中任意节点上的数据状态都是完全一致的，并且整个架构实现了去中心化，所有节点都是对等的，即允许你在任意节点上进行写入和读取，集群会把数据状态同步至其他所有节点。但目前 PXC 集群只支持 InnoDB 存储引擎，并具有以下限制：

+ 添加新节点时，必须从现有节点之一复制完整数据集。如果是 100GB，则复制 100GB。为了减少网络开销，建议在搭建集群前使用备份的方式将所有节点初始的数据状态调整至一致。
+ 不支持 LOCK TABLES ，在多主设置的情况下也不支持 UNLOCK TABLES。
+ 不支持锁定功能，如 GET_LOCK()，RELEASE_LOCK() 等。
+ 由于可能在提交时回滚，因此也不支持 XA 事务 (分布式事务) 。
+ 所有表必须具有主键。
+ 由于节点是对等的，所以整个集群的写吞吐量受限于性能最差的节点，如果一个节点变慢，则整个群集都会变慢。因此应该保证所有节点的硬件配置一致，并避免单个节点超负载运行。
+ 允许的最大事务大小由 wsrep_max_ws_rows 和 wsrep_max_ws_size 参数共同定义，因此超大型事务会被拆分为一系列小型事务，如加载大数据集 LOAD DATA INFILE。
+ 由于在集群级别采用乐观锁进行并发控制，所以事务在 COMMIT 阶段仍然有被中止的可能。如两个事务在不同的集群节点上提交对相同的行的写入，此时只有其中一个可以成功提交，另一个将被中止。

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/pxc-cluster.png"/> </div>
虽然 PXC 集群存在以上限制，但就目前而言，它仍然是解决数据一致性和高可用性的最好方案，其搭建步骤如下：

## 二、集群搭建

为保证集群高可用，群集最少要有 3 个节点，这里以搭建一个 3 节点的集群为例，具体如下：

### 2.1 准备安装

**1. 删除 MariaDB**

1.这里我的服务器版本为 Centos 7.x ，需要删除自带的 MariaDB 数据库，避免对后面安装造成影响：

```shell
yum -y remove mari*
```

**2. 开放访问墙端口**

开放以下四个防火墙端口，其作用和开放命令分别如下：

```shell
# MySQL 对外提供服务的端口
firewall-cmd --zone=public --add-port=3306/tcp --permanent
# 请求进行全量同步(SST)的端口
firewall-cmd --zone=public --add-port=4444/tcp --permanent
# 集群中各个节点间的通讯端口
firewall-cmd --zone=public --add-port=4567/tcp --permanent
# 请求进行增量同步(IST)的端口
firewall-cmd --zone=public --add-port=4568/tcp --permanent
```

**3. 关闭SELINUX**

SELinux 安全模块可能会限制对 Percona XtraDB Cluster 的数据访问。此时可以在运行时使用 `setenforce 0` 命令进行更改，也可以通过修改 `/etc/selinux/config` 文件中的 SELINUX 属性的值为 disabled ，从而进行永久性的更改：

```shell
vi /etc/selinux/config
# 修改
SELINUX=disabled
```

修改该文件后需要重启才能生效：

```shell
reboot
```

### 2.2  在线安装

配置 yum 源后，直接使用 yum 命令进行在线安装，命令如下：

```shell
sudo yum install https://repo.percona.com/yum/percona-release-latest.noarch.rpm
sudo yum install Percona-XtraDB-Cluster-57
```

使用以上命令安装完成后，会同时安装好 Percona Server 数据库，它基于 MySQL 社区版进行了扩展增强，并完全兼容原有版本，使用方式也完全一致，启动命令如下：

```shell
sudo systemctl start mysql
```

### 2.3 修改密码

使用以下命令获取安装时自动生成的 root 账户的密码：

```shell
sudo grep 'temporary password' /var/log/mysqld.log
```

使用 root 账户登录，并修改其账户密码：

```shell
# 登录服务
mysql -u root -p
# 修改密码
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
# 退出服务
mysql> exit
```

之后使用以下命令停止 MySQL 服务：

```shell
sudo systemctl stop mysql
```

### 2.4 搭建集群

以上安装过程在三台主机上均相同执行，之后就可以开始集群的搭建。首先需要修改每个服务器上的 `/etc/my.cnf` 文件，第一个节点上需要增加的内容如下：

```properties
[mysqld]

# PXC集群中每个MySQL实例的唯一标识，不能重复
server-id=1  

wsrep_provider=/usr/lib64/galera3/libgalera_smm.so

# PXC集群的名称和所有服务地址
wsrep_cluster_name=pxc-cluster  
wsrep_cluster_address=gcomm://192.168.0.226,192.168.0.227,192.168.0.228

# 当前节点的名称和服务地址
wsrep_node_name=pxc1 
wsrep_node_address=192.168.0.226

# 指定同步方法和账户信息，这个用户在下文会进行创建
wsrep_sst_method=xtrabackup-v2 
wsrep_sst_auth= sstuser:123456

#开启严厉模式,它会阻止用户执行 Percona XtraDB Cluster 所不支持的功能。
pxc_strict_mode=ENFORCING  

# 指定二进制日志的格式
binlog_format=ROW 
# 指定默认的存储引擎
default_storage_engine=InnoDB 
# Galera 仅支持 InnoDB 的 interleaved(2) 锁定模式:
# 该模式下所有 INSERT SQL 都不会有表级 AUTO-INC 锁,多个语句可以同时执行
innodb_autoinc_lock_mode=2 
```

第二、三个节点的配置与上面基本相同，但是需要修改 server id 以及当前节点的名称和地址，具体如下：

```properties
server-id=2
wsrep_node_name=pxc2
wsrep_node_address=192.168.0.227
```

```properties
server-id=3
wsrep_node_name=pxc3
wsrep_node_address=192.168.0.228
```

### 2.5 启动集群

第一个节点需要以引导模式启动：

```shell
sudo systemctl start mysql@bootstrap.service
```

在将其他节点添加到群集之前，需要登录当前节点，来为 SST 操作创建用户并提供权限，命令如下：

```shell
# 创建用户
CREATE USER 'sstuser'@'localhost' IDENTIFIED BY '123456';
# 授予权限
GRANT RELOAD, LOCK TABLES, PROCESS, REPLICATION CLIENT ON *.* TO 'sstuser'@'localhost';
# 刷新权限
FLUSH PRIVILEGES;
```

接着在第二和第三个节点上正常启动数据库服务，命令如下：

```shell
sudo systemctl start mysql
```

启动后，可以登录任意节点并使用以下命令查看集群状态。输出中的 wsrep_cluster_size 的值应该为 3 ，即集群中节点总数为 3，此时代表所有节点都已成功加入集群，至此集群已经搭建完成。

```shell
mysql> show status like 'wsrep%';
+----------------------------------+----------------------------------------------------------+
| Variable_name                    | Value                                                    |
+----------------------------------+----------------------------------------------------------+
| wsrep_local_state_uuid           | 8bcc22cf-bfab-11e9-8a49-6e46c7af709e                     |
.......
| wsrep_incoming_addresses         | 192.168.0.227:3306,192.168.0.228:3306,192.168.0.226:3306 |
| wsrep_gcomm_uuid                 | c8afc276-c623-11e9-a9ea-677d72419479                     |
| wsrep_cluster_conf_id            | 3                                                        |
| wsrep_cluster_size               | 3                                                        |
| wsrep_cluster_state_uuid         | 8bcc22cf-bfab-11e9-8a49-6e46c7af709e                     |
| wsrep_cluster_status             | Primary                                                  |
| wsrep_connected                  | ON                                                       |
| wsrep_local_bf_aborts            | 0                                                        |
| wsrep_local_index                | 2                                                        |
| wsrep_provider_name              | Galera                                                   |
| wsrep_provider_vendor            | Codership Oy <info@codership.com>                        |
| wsrep_provider_version           | 3.37(rff05089)                                           |
| wsrep_ready                      | ON                                                       |
+----------------------------------+----------------------------------------------------------+
```

### 2.6 节点下线

PXC 集群允许动态下线节点，但需要注意的是节点的启动命令和关闭命令必须一致，如以引导模式启动的第一个节点必须以引导模式来进行关闭：

```shell
systemctl stop mysql@bootstrap.service
```

其他节点则可以按照正常方式关闭：

```shell
service stop mysql
```

由于所有节点都是对等的，所以下线第一个节点和下线其他节点在效果上都是相同的，以上就是关于 PXC 集群搭建的全部内容。



## 参考资料

[Percona XtraDB Cluster 5.7 Documentation](https://www.percona.com/doc/percona-xtradb-cluster/LATEST/index.html)

# PXC 集群搭建

## 一、PXC 集群

## 二、创建PXC集群

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

安装完成后，通过以下命令启动数据库服务：

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

在将其他节点添加到群集之前，需要登录当前节点，来为 SST 创建用户并提供权限，命令如下：

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
show status like 'wsrep%';
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

由于所有节点都是对等的，所以下线第一个节点和下线其他节点在效果上都是相同的。
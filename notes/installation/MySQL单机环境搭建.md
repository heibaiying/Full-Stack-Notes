# MySQL 单机环境搭建

## 一、下载并解压

这里我采用的是二进制安装包的方式进行安装，安装包的下载地址为：https://dev.mysql.com/downloads/mysql/，按需选择对应的版本后进行下载：

<div align="center"> <img src="https://github.com/heibaiying/Full-Stack-Notes/blob/master/pictures/mysql-version.png"/> </div>

下载后进行解压，并对解压后的文件夹进行重命名，以便在后面的配置中进行引用：

```shell
tar -zxvf mysql-8.0.17-el7-x86_64.tar.gz -C /usr/app
mv mysql-8.0.17-el7-x86_64/ mysql-8.0.17
```

## 二、配置环境变量

配置 MySQL 环境变量：

```shell
 vim /etc/profile
```

```shell
export MYSQL_HOME=/usr/app/mysql-8.0.17
export PATH=$MYSQL_HOME/bin:$PATH
```

使得配置的环境变量立即生效：

```shell
source /etc/profile
```

## 三、创建用户组和用户

为了安全起见，建议使用专门的用户组来管理 MySQL 服务。创建命令如下：

```shell
# 创建用户组
groupadd mysql 
# 创建用户
useradd -g mysql mysql
# 设置密码
passwd mysql
# 将安装目录的所有者改为mysql用户
chown -R mysql:mysql /usr/app/mysql-8.0.17
```

## 四、数据库配置

 MySQL 会默认读取 `/etc/my.cnf` 路径上的配置文件，该文件需要手动创建，内容如下。下面是一个最小化的配置，主要是定义了 MySQL 的安装目录和数据存放目录：

```shell
[mysqld]
# 每个Mysql实例的唯一编号
server-id = 1
# 服务端口号 默认3306
port = 3306
# 安装目录
basedir = /usr/app/mysql-8.0.17
# 数据存放目录
datadir = /usr/app/mysql-8.0.17/data
# 临时目录 
tmpdir  = /tmp
# 设置socket文件所在目录
socket  = /tmp/mysql.sock
# 服务端字符集
character-set-server = utf8mb4
```

## 五、初始化 MySQL

执行以下命令进行初始化：

```shell
/usr/app/mysql-8.0.17/bin/mysqld --initialize --user=mysql \
--basedir=/usr/app/mysql-8.0.17 --datadir=/usr/app/mysql-8.0.17/data
```

注意观察控制台输出，控制台上会显示 root 用户的临时登录密码，拷贝好该密码，以便后面使用：

```shell
[Note][MY-010454][Server] A temporary password is generated for root@localhost: NTWbsvTJj9<P
```

## 六、启动 MySQL 服务

首先将 `mysql.server` 拷贝到  /etc/init.d/ 目录下，命令如下：

```shell
cp /usr/app/mysql-8.0.17/support-files/mysql.server  /etc/init.d/mysql
```

之后再启动 MySQL 服务，出现 `SUCCESS` 则代表启动成功：

```shell
/etc/init.d/mysql start
```

## 七、登录 MySQL 

MySQL 服务启动完成后，可以使用下面的命令进行登录，登录密码为上面生成的临时密码：

```
mysql -u root -p
```

使用临时密码登录后， root 用户还不能进行任何操作，需要先进行密码修改，命令如下：

```shell
alter user 'root'@'localhost' identified by '123456';
```

## 八、设置远程访问

默认情况下，MySQL 只允许来自本机的连接，想要从其它主机上访问 MySQL 服务，需要配置远程登录用户，命令如下：

```shell
# 创建名为 heibaiying 的用户
create user heibaiying@'%' identified by '123456';
# 授予其可以在任意主机上进行连接的权限
grant all privileges on *.* to heibaiying@'%' with grant option;
# 刷新权限
flush privileges;
```

配置完成后就可以在其他任意主机上使用该用户来连接 MySQL 服务。至此，MySQL 的单机环境已经搭建完成。
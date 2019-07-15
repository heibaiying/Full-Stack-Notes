# MongoDB 单机版本环境搭建

## 一、下载并解压

下载地址为： https://www.mongodb.com/download-center/community ，选择所需版本的 MongoDB 后进行下载：

![mongodb-version-select](D:\Full-Stack-Notes\pictures\mongodb-version-select.png)

这里我下载的版本为 `4.0.10`  , 安装环境为 `RHEL 7.0`，下载后进行解压：

```shell
 tar -zxvf mongodb-linux-x86_64-rhel70-4.0.10.tgz -C /usr/app
```

## 二、配置环境变量

配置环境变量：

```shell
vi /etc/profile
```



```shell
export MONGODB_HOME=/usr/app/mongodb-linux-x86_64-rhel70-4.0.10/
export  PATH=${MONGODB_HOME}/bin:$PATH
```

使得配置的环境变量立即生效：

```shell
source /etc/profile
```

## 三、修改配置

MongoDB 默认存放数据的目录为 `/var/lib/mongo` ，默认存放日志的目录为 `/var/log/mongodb`，采用 TGZ 安装包进行安装时，程序不会自动创建这两个目录，需要预先手动创建。同时由于 `/var/` 下只能存放临时文件，所以这里我们使用其他目录进行存储，命令如下：

```shell
mkdir -p /home/mongodb/data
mkdir -p /home/mongodb/log
```

修改配置，采用 TGZ 安装包进行安装时，程序不会自动创建配置文件，需要手动创建：

```
vim /etc/mongod.conf
```

在配置文件中增加如下配置，这里的配置采用的是 YAML 的格式：

```shell
systemLog:
    destination: file
    path: "/home/mongodb/log/mongod.log"
    logAppend: true
storage:
    dbPath: "/home/mongodb/data"
net:
    port: 27017
    # 如果不修改绑定IP,默认只能在本机访问数据库服务
    bindIp: 0.0.0.0
```

> MongoDB 的所有配置项可以参考其官方文档：[Configuration File Options](https://docs.mongodb.com/manual/reference/configuration-options/)

## 四、启动服务

由于已经配置过环境变量，这里直接启动即可，命令如下：

```shell
mongod -f /etc/mongod.conf
```

## 五、连接服务

这里直接使用 mongo shell 进行连接，mongo shell 默认就是连接到本地的 `27017` 端口，所以直接启动即可：

```shell
mongo
```

成功进入交互式命令行则代表启动成功。
# Redis 单机环境搭建

### 一、下载并解压

下载地址：http://download.redis.io/releases/ ，下载后进行解压：

```shell
# 下载
http://download.redis.io/releases/redis-5.0.5.tar.gz
# 解压
tar -zxvf redis-5.0.5.tar.gz
```

### 二、编译

进入解压后的根目录，执行下面的命令：

```shell
make
```

### 三、启动服务

进入`src`目录，执行下面的命令，启动 Redis 服务：

```shell
./redis-server
```

### 四、启动客户端

在`src`目录下，执行以下命令启动客户端：

```shell
# 不加任何参数默认连接的也是 127.0.0.1:6379
redis-cli -h 127.0.0.1 -p 6379
```

### 五、修改访问配置

默认情况下，不能从其他主机访问 Redis 服务。如果想要从其他主机访问 Redis 服务，需要修改根目录下的` redis.conf`：

```shell
bind 127.0.0.1
```

默认绑定的是本机地址，可以改成其他地址。如果想要所有主机都能访问，需要注释掉上面一行，同时将保护模式关闭：

```shell
protected-mode no
```

修改完成后，以指定配置的方式启动：

```shell
./redis-server ../redis.conf
```


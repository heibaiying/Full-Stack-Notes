# ElasticSearch 和 Kibana 单机环境搭建

<nav>
<a href="#一ElasticSearch-安装">一、ElasticSearch 安装</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-下载并解压">1.1 下载并解压</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12--修改软件配置">1.2  修改软件配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-修改服务器配置">1.3 修改服务器配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#14-启动服务">1.4 启动服务</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#15-启动验证">1.5 启动验证</a><br/>
<a href="#二Kibana-安装">二、Kibana 安装</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-修改配置">2.1 修改配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-启动服务">2.2 启动服务</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-访问页面">2.3 访问页面</a><br/>
</nav>

## 一、ElasticSearch 安装

### 1.1 下载并解压

Elastic 所有软件的下载地址均为 ：https://www.elastic.co/cn/downloads/past-releases ，下载相同版本的 ElasticSearch 和 Kibana，下载后进行解压：

```shell
tar -zxvf elasticsearch-7.2.0-linux-x86_64.tar.gz -C /usr/app/
tar -zxvf kibana-7.2.0-linux-x86_64.tar.gz -C /usr/app/
```

### 1.2  修改软件配置

修改安装目录下的 `config/elasticsearch.yml` 文件，修改内容如下：

```shell
# 当前节点的名称
node.name: node-1
# 修改绑定地址，默认为本机地址，此时只能在本机访问ElasticSearch服务，想要所有主机都能访问，则修改为0.0.0.0
network.host: 0.0.0.0
http.port: 9200
cluster.initial_master_nodes: ["node-1"]
```

### 1.3 修改服务器配置

如果你采用默认的服务器配置进行启动，通常会抛出下面两个异常：

```shell
ERROR: [2] bootstrap checks failed
[1]: max file descriptors [4096] for elasticsearch process is too low, increase to at least [65535]
[2]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
```

此时需要对服务器配置进行两项更改：

#### 1. sysctl.conf

编辑 `/etc/sysctl.conf` 文件，增加如下配置： 

```shell
# 限制一个进程可以拥有的VMA(虚拟内存区域)的数量
vm.max_map_count=262144
```

修改完成后，如果想要在不重启的情况下使得该配置生效，则需要执行以下命令：

```shell
/sbin/sysctl -p
```

#### 2. limits.conf

编辑 `/etc/security/limits.conf` 文件，增加如下配置：

```
* soft nofile 65536
* hard nofile 65536
root soft nofile 65536
root hard nofile 65536
```

修改配置完成重启 shell 客户端即可生效，想要验证是否生效，可以使用命令 `ulimit -a` 查看输出中的 `open files` 的值是否为 65536。

### 1.4 启动服务

进入安装目录的`bin`目录下，执行以下命令启动服务。这里为了观察效果使用前台方式启动，如果想要以后台进程的方式启动，则需要在后面加上`-d`参数：

```she
./elasticsearch
```

需要特别注意的是，处于安全的考虑，Elasticsearch 不允许使用 root 账户启动服务，所以启动时需要切换到其他用户。同时启动用户必须拥有 Elasticsearch 目录的访问权限，可以先使用`chown`命令授权后再使用`su`命令切换到对应用户，示例如下： 

```shell
useradd heibaiying
chown -R heibaiying:heibaiying /usr/app/elasticsearch-7.2.0/
```

### 1.5 启动验证

想要验证是否启动成功，可以使用`jps`命令查看`Elasticsearch`进程是否启动，也可以访问`9200`端口，出现如下页面则代表启动成功：

<div align="center"> <img src="https://github.com/heibaiying/Full-Stack-Notes/blob/master/pictures/elk-web-ui.png"/> </div>

## 二、Kibana 安装

### 2.1 修改配置

修改安装目录下的 `config/kibana.yml` 文件，修改内容如下：

```shell
server.port: 5601
server.host: 0.0.0.0
```

### 2.2 启动服务

同样 Kibana 不允许使用 root 账户启动服务，所以启动时候需要切换到其他用户。同时启动用户必须拥有 Kibana 目录的访问权限，可以先使用`chown`命令授权后再使用`su`命令切换到对应用户，示例如下： 

```shell
chown -R heibaiying:heibaiying /usr/app/kibana-7.2.0-linux-x86_64/
```

切换用户，并进入到安装目录的`bin`目录下，启动服务：

```shell
# 切换用户
su - heibaiying
# 启动服务
./kibana
```

需要说明的是这里 kibana 启动时候没有`-d`这个参数，想要后台启动，则可以使用以下命令：

```shell
nohup ./kibana  &
```

### 2.3 访问页面

kibana Web UI 的访问端口号为`5601`，出现以下页面则代表启动成功：

<div align="center"> <img src="https://github.com/heibaiying/Full-Stack-Notes/blob/master/pictures/kibana-web-ui.png"/> </div>

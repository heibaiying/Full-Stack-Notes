# Nginx 编译方式安装

## 一、安装依赖

+  **PCRE**：用于支持正则表达式，它主要被 NGINX Core 和 Rewrite 模块所需要：

```shell
# PCRE库的编译需要该组件，所以需要预先安装
$ yum -y install gcc-c++

$ wget https://ftp.pcre.org/pub/pcre/pcre-8.42.tar.gz
$ tar -zxf pcre-8.42.tar.gz
$ cd pcre-8.42
$ ./configure
$ make
$ sudo make install
```

+ **zlib** ：用于支持 header 头压缩，它主要被 NGINX Gzip 模块所依赖：

```shell
$ wget http://zlib.net/zlib-1.2.11.tar.gz
$ tar -zxf zlib-1.2.11.tar.gz
$ cd zlib-1.2.11
$ ./configure
$ make
$ sudo make install
```

+ **OpenSSL**：用于支持 HTTPS 协议，它主要被 NGINX SSL 模块和其他模块所依赖：

```shell
yum install openssl openssl-devel
```

## 二、安装 Nginx

### 2.1 下载并解压

下载所需版本的 Nginx 并进行解压，Nginx 版本号的规则为：`主版本号.次版本号.修订号`，其中稳定版的次版本号为偶数，测试版的次版本号为奇数，生产环境下应尽量下载稳定版：

```shell
$ wget https://nginx.org/download/nginx-1.16.1.tar.gz
$ tar -zxvf nginx-1.16.1.tar.gz
```

### 2.2 编译安装

按需编译 Nginx，可以使用 `--with` 来包含非默认安装的模块，或使用 `--without` 来排除默认安装的模块。关于全部模块的信息，可以使用 ` ./configure  --help` 命令查看或查阅官方文档：https://nginx.org/en/docs/configure.html  ：

```shell
$ cd nginx-1.16.1

$ ./configure   \
--prefix=/usr/app/nginx-1.16.1  \
--with-pcre=/usr/app/pcre-8.42  \
--with-zlib=/usr/app/zlib-1.2.11 \
--with-http_ssl_module \ 	# 启用HTTPS支持
--with-stream  \ 		# 启用TCP和UDP代理功能
--with-mail=dynamic 		# 启用邮件代理功能

$ make
$ sudo make install
```

### 2.3 配置环境变量

```shell
$ vim /etc/profile
```

增加如下配置：

```shell
export NGINX_HOME=/usr/app/nginx-1.16.1
export PATH=${NGINX_HOME}/sbin:$PATH
```

使得配置的环境变量立即生效：

```shell
$ source /etc/profile
```


# HTTPS

## 一、核心概念

### 1.1 SSL

安全套接层（英语：Secure Sockets Layer，缩写：SSL）是一种安全协议，目的是为互联网通信提供安全保障，最早由网景公司（Netscape）推出。SSL 协议有三个版本，分别是 SSL v1、SSL v2、SSL v3：

- v1 版本从未公开过，因为存在严重的安全漏洞。
- v2 版本在1995年2月发布，但因为存在多个严重的安全漏洞而被 v3 版本替代。
- v3 版本在1996年发布，是由网景公司完全重新设计的。

### 1.2 TLS

1966 年，TETF（Internet Engineering Task Force）组织在 SLL v3 的基础进一步进行了标准化，微软为这个新的协议取名为 TLS v1.0，这也就是TLS（Transport Layer Security）的由来。之后 TLS 继续发布了 v1.1，v1.2，v1.3 版本协议，当前主流的版本为 v1.2。

### 1.3 OpenSSL

OpenSSL 是一个开源的底层密码库，封装了所有的密码学算法，并为 TLS/SSL 提供了功能完善的工具库，因此它是 TLS/SSL 协议的具体实现。

### 1.4 HTTPS

HTTPS （Hyper Text Transfer Protocol over SecureSocket Layer）是在 HTTP 的基础上通过 SSL/TLS 层来进行传输加密和身份认证，进而保证通讯的安全性。除此之外它的报文结构、请求方法、连接管理等都完全沿用 HTTP 原有的模式，因此可以很方便地将原有 HTTP 服务转换为 HTTPS 服务。



## 二、数据安全

HTTPS 的数据安全主要是通过 SSL/TLS  协议来进行实现的，SSL/TLS 则主要采用了以下方式来保证传输的安全：

### 2.1 非对称加密



### 2.2 对称加密



## 三、握手过程


# HTTPS

<nav>
<a href="#一基本概念">一、基本概念</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-SSL">1.1 SSL</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-TLS">1.2 TLS</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-OpenSSL">1.3 OpenSSL</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#14-HTTPS">1.4 HTTPS</a><br/>
<a href="#二数据安全">二、数据安全</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-非对称加密">2.1 非对称加密</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-对称加密">2.2 对称加密</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-摘要算法">2.3 摘要算法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-数字签名">2.4 数字签名</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#25-中间人攻击">2.5 中间人攻击</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#26-CA-证书">2.6 CA 证书</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#27-PKI-体系">2.7 PKI 体系</a><br/>
<a href="#三握手过程">三、握手过程</a><br/>
</nav>

## 一、基本概念

### 1.1 SSL

SSL（Secure Sockets Layer，安全套接层）是一种安全协议，目的是为互联网通信提供安全保障，最早由网景公司（Netscape）推出。SSL 协议有三个版本，分别是 SSL v1、SSL v2、SSL v3：

- v1 版本因为存在严重的安全漏洞，所以从未公开过。
- v2 版本在1995 年 2 月发布，但因为存在多个严重的安全漏洞而被 v3 版本替代。
- v3 版本在 1996 年发布，由网景公司全部进行重新设计。

### 1.2 TLS

1966 年，IETF（Internet Engineering Task Force，国际互联网工程任务组）在 SSL v3 的基础进一步进行了标准化，微软为这个新的协议取名为 TLS v1.0 ，这也就是 TLS（Transport Layer Security，安全传输层协议）的由来。之后 TLS 继续发布了 v1.1，v1.2，v1.3 版本，当前主流的版本为 v1.2 。

### 1.3 OpenSSL

OpenSSL 是一个开源的底层密码库，封装了所有的密码学算法，并为 TLS/SSL 协议提供了完善的工具库，可以把它看做是 TLS/SSL 协议的具体实现。

### 1.4 HTTPS

HTTPS （Hyper Text Transfer Protocol over SecureSocket Layer，超文本传输安全协议）是在 HTTP 的基础上通过 SSL/TLS 层来进行传输加密和身份认证，从而保证通讯的安全性。除此之外它的报文结构、请求方法等都完全沿用 HTTP 原有的模式，因此可以很方便地将原有 HTTP 服务转换为 HTTPS 服务。

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/http+tls.png"/> </div>

## 二、数据安全

具体而言，HTTPS 主要通过以下几种方式来保证通信的安全：

### 2.1 非对称加密

非对称加密算法需要一对密钥：公开密钥（public key，简称公钥）和私有密钥（private key，简称私钥）来进行加解密。用公钥加密的数据只有对应的私钥才能解密，反之亦然。因为加密和解密使用的是两个不同的密钥，从而叫作非对称加密算法。

HTTPS 的公钥可以由任意的客户端持有，但私钥只能由服务器持有，因此所有经过公钥加密的数据只能由对应的服务器解密。

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_非对称加密.png"/> </div>


### 2.2 对称加密

非对称加密算法通常是基于一些复杂的数学问题来实现的，因此其加解密过程需要大量的运算，对应的加解密时间也比较长。为了兼顾性能与安全两方面的考虑，HTTPS 还引入了对称加密算法。

对称加密算法采用同一个密钥来进行信息的加密和解密，因此也被称为单密钥加密算法，其加解密速度都比较快。HTTPS 会在握手阶段采用非对称加密算法来生成对称加密所需的密钥，而之后的过程，因为要涉及到大量业务信息的传输，故都采用对称加密来提升性能。

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_对称加密.png"/> </div>


### 2.3 摘要算法

通过以上两步，在网络中传输的数据已经是密文，此时即便数据被窃取，窃取者也无法解析。但是窃取者仍然可以对密文进行截取和重发，进而改变用户预期的行为，此时需要引入摘要算法来对数据的完整性进行校验。

摘要算法是一种单向的，不需要密钥的算法，它可以将任意长度的输入转换为固定长度的输出。并且能够保证对于任意相同的输入在同样的摘要算法下总是输出相同的结果；反之，如果输入不相同，则采用相同摘要算法得到的结果必然不相同。

HTTPS 会为需要传输的数据生成摘要信息，然后将经过会话密钥加密后的摘要和数据传送给服务器。服务器进行解密后，首先需要使用同样的摘要算法为数据生成摘要，并与客户端传送过来的摘要进行比较；如果一致，则证明数据没有被篡改。

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_摘要会话密钥加密.png"/> </div>


### 2.4 数字签名

当服务器处理完客户端的请求后，需要将处理结果返回给客户端。此时服务器需要证明这些返回数据是由真正持有私钥的服务器返回的，而不是其它伪装服务器返回的。想要保证这一点，需要使用服务器独有的私钥对数据进行加密，这种行为也称为数字签名。

由于非对称性加密比较耗时，因此只会对返回数据的摘要进行加密。当客户端收到服务器的响应时，首先尝试使用公钥对加密后的摘要进行解密，如果解密失败，则表示是其他伪装服务器返回的；如果解密成功，则继续对数据的完整性进行校验。

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_摘要私钥加密.png"/> </div>


### 2.5 中间人攻击

经过以上步骤，数据的传输已经相当安全了，但此时还是无法抵御中间人攻击：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_中间人攻击.png"/> </div>


简单来说，中间人攻击就是服务器传递给客户端的公钥可能被攻击者替换，进而丧失数据安全的一种攻击方式：

+ 首先，中间攻击者将服务器发送给客户端的公钥替换为自己的公钥；
+ 假设没有任何认证机制，那么此时客户端并不知道公钥被替换，仍然使用攻击者的公钥对数据进行加密；
+ 攻击者接收到加密数据后，使用攻击者自己的私钥进行解密，然后将解密后的数据用真正的公钥进行加密后发送给服务器，并接收响应。

想要解决中间人攻击，客户端首先需要保证自己拿到的公钥是正确的公钥，此时需要借助 CA 证书和 PKI 体系。

### 2.6 CA 证书

CA（Certification Authority）是证书的签发机构，它是公钥基础设施（Public Key Infrastructure，PKI）的核心，负责签发证书、认证证书和管理已颁发证书。如果用户想得到一份属于自己的证书，他可以向 CA 机构提出申请。在 CA 判明申请者的身份后，便为他分配一个公钥，并将该公钥与申请者的身份信息绑在一起，然后为其签名，形成证书后颁发给申请者。

顶级的 CA 机构有 Symantec、Comodo、GeoTrust、DigiCert，但是通常它们并不支持给厂商颁发证书，而是授权给中间厂商，由中间厂商再颁发给应用厂商。从而形成 CA 认证链：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_证书链.png"/> </div>


就 CA 证书类型而言，其分为以下三类：

- **DV (Domain Validation)**：最基础的域名型证书，只需要验证域名的所有权，特点是颁发速度快，但不知道所属者的身份。
- **OV (Organization Validation)**：面向企业用户，需要验证网站所属企业的真实身份。
- **EV (Extended Validation)**：是目前最高信任级别的 SSL 证书。按照国际规范审查网站企业身份和域名所有权，确保网站身份的真实可靠。

通过点击浏览器上锁图标可以查看对应网站的证书状态，示例如下：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/http_baidu_ov.png"/> </div>


<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/http_baidu_ov_证书.png"/> </div>


除了以上三种证书外，你还可以使用 Openssl 生成自签名证书，但由于自签名证书并不在整个认证链上，所以其通常不被浏览器所信任，访问时会出现以下警告：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_非安全的连接.png"/> </div>


### 2.7 PKI 体系

PKI（Public Key Infrastructure，公开密钥基础建设系统）由数字证书、认证中心（CA）、证书资料库、证书吊销系统、密钥备份及恢复系统、PKI 应用接口系统等多个部分共同组成，其目的在于创造、管理、分配、使用、存储以及撤销数字证书。

以 CRL（Certificate revocation list，证书吊销列表）为例，它主要用于列出所有不再被信任的证书。如果一个证书所属单位不再被信任，则该证书将被撤销，并添加到 CRL 中。CRL 由 CA 生成并定期更新，以保证整个证书认证体系的持续可靠。



## 三、握手过程

以 `TLS v1.2` 版本中采用 ECDHE 算法的握手过程为例，其具体流程如下：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_tsl_v1.2_ECDHE.jpg"/> </div>


1. TLS/SSL 协议是基于 TCP/IP 协议的，因此需要先等待 TCP 三次握手完成；

2. TCP 握手完成后，客户端首先发起一个 `Client Hello` 请求，里面包含客户端版本号、所有支持的密码套件、以及一个随机数 `Client Random`;

3. 服务器收到该请求后，会返回一个 `Server Hello` 消息，里面包含选中的用于本次通信的密码套件，以及一个随机数 `Server Random`；

4. 紧接着，为了证明自己的身份，服务器需要将证书发送给客户端。客户端收到证书后，沿着证书链逐级向上验证，确保拿到的是有效的证书；

5. 之后服务器还会发送一个 `Server Key Exchange` 消息，里面包含了进行 ECDHE 算法所需的各种参数 `Server Params` ：

    <div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_server_key_exchange.png"/> </div>


​    

6. 客户端按照密码套件的要求，也生成一个 `Client Params`，并通过 `Client Key Exchange` 消息发送给服务器；

    <div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_client_key_exchange.png"/> </div>


​    

7. 经过以上步骤的交换，服务器和客户端都有了 `Client Params` 和 `Server Params`，它们分别根据这两个参数进行计算，ECDHE 算法能够保证客户端和服务器算出来的值是一样的，这个算出来的值就是预主密钥 `Pre-Master`；

8. 最后再利用预主秘钥，客户端随机数，服务器随机数共同算出真正的主密钥 `Master_Secret`，算法如下：

   ```shell
   master_secret = PRF(pre_master_secret, 
                       "master secret", 
                       ClientHello.random + ServerHello.random)
   ```

   这里的 PRF 是一个伪随机函数，用于增强 master_secret 的随机性。主密钥 `Master_Secret` 的长度固定为 48 个字节，从中可以推导出以下四个密钥：

   + client_write_MAC_key
   + server_write_MAC_key
   + client_write_key
   + server_write_key

   `client_write_MAC_key` 和 `server_write_MAC_key` 主要用于身份验证和完整性校验，而 `client_write_key` 和 `server_write_key` 则是对称加密中真正使用的会话密钥：

   + 客户端使用 `client_write_key` 加密，服务器对称地使用 `client_write_key` 解密；
   + 服务器使用 `server_write_key` 加密，客户端对称地使用 `server_write_key` 解密。

9. 有了会话密钥后，客户端会发送一个 `Change Cipher Spec` 请求，告知服务器将加密方式由非对称加密转换为对称加密；

10. 紧接着，为了验证对称加密，客户端会将所有的握手消息（Handshake Message）进行加密，通过一个 `Encrypted Handshake Message` 请求发送给服务器；

11. 服务器解密并进行验证，如果验证通过，则也返回给客户端 `Change Cipher Spec` 和 `Encrypted Handshake Message` 消息，代表双方共同达成协议，之后的通信都采用对称加密的方式。

12. 除此之外，服务器还会返回一个 `New Session Ticket` 消息，其内容如下：

     <div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures/https_new_session_ticket.png"/> </div>



`New Session Ticket` 是一种优化连接的方式：服务器将会话信息加密后以 Ticket（票据）的方式发送给客户端 ，服务器本身并不存储会话信息。客户端接收到 Ticket 后，将其储到内存中，如果想恢复会话，则下次连接的时候将票据发送给服务器端；服务器端进行解密，如果确认无误则表示可以进行会话恢复，这样就简化了以上复杂的握手过程。

关于使用 WireShark 分析 HTTPS 握手的详细步骤，可以参考：[使用 WireShark 分析 HTTPS 握手过程](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/WireShark_HTTPS.md)

  

## 参考资料

+ 虞卫东 . 《深入浅出 HTTPS：从原理到实战》 .  电子工业出版社 . 2018-06 


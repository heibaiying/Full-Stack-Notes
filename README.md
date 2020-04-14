# Full-Stack-Notes

<div align="center"> <img width="380px" src="pictures/full-stack-notes-logo.png"/> </div>
<br/>
<div align="center">
    <img src="pictures/芽.png"/>
    <strong>一个处于萌芽阶段的知识库，用于持续分享自己的所见、所学、所思！</strong>
</div>


## :coffee: JAVA

1. [Java 反射与注解](notes/Java_反射与注解.md)

   反射机制、自定义注解、@Target 与 @Retention、注解的继承

2. [Java 并发编程](notes/Java_并发编程.md)

   非原子性协定、计算机多级高速缓存、缓存一致性协议、写缓冲与无效化队列、内存屏障、锁机制、无锁 CAS、线程池

3. [Java 设计模式](notes/Java_设计模式.md)

   软件设计原则、单例模式（使用序列化和反射破坏单例、防御序列化和反射攻击、枚举类单例）等 23 种设计模式

4. [Java 虚拟机](notes/Java_虚拟机.md)

   Java 内存区域、垃圾收集算法、经典垃圾收集器、双亲委派模型、分层编译、热点代码探测、方法内联、逃逸分析
   
5. [JVM 性能监控之命令行工具](notes/JVM_性能监控之命令行工具.md)

   jps 命令、jstat 命令、jinfo 命令、jmap 命令、jhat 命令、jstack 命令

6. [JVM 性能监控之可视化工具](notes/JVM_性能监控之可视化工具.md)

   JConsole、VisualVM 、监控本地进程、监控远程进程

7. IO、NIO、AIO

8. Socket 网络编程系列

9. 高性能网络框架 Netty

10. Java 集合类源码解析

11. [Tomcat 架构解析](notes/Tomcat_架构解析.md)

    核心组件、连接器、多层容器、请求处理流程、程序启动过程、类加载器

12. 函数式编程

<br/>

## :globe_with_meridians: 计算机与网络基础

1. [计算机网络模型](notes/计算机网络.md)

   四层、五层、七层计算机网络模型、信道复用、PPP 协议、ARP 协议、划分子网与构成超网、TCP 三次握手与四次挥手

2. HTTP 协议详解

3. HTTPS 协议详解

4. 抓包神器 Wireshark

5. 计算机组成原理

 <br/>  

## :computer: 前端基础

1. [JavaScript 基础](notes/JavaScript_基础.md)

   基本数据类型、引用类型、内置对象（Global 与 window）、作用域与闭包、对象设计

2. [ECMAScript 6.0 基础](notes/ES6_基础.md)

   变量声明、对象字面量、对象解构、Symbol、迭代器与生成器、类、代理与反射、模块化
   
3. CSS 基础

   选择器、非局部样式、布局样式、效果属性、CSS 动画

4. JavaScript 设计模式

<br/>

## :dolphin: 数据库

### MySQL

1. [MySQL 核心概念](notes/MySQL_基础.md)

   B+ Tree 树、聚集索引和非聚集索引、共享锁与排他锁、意向共享锁与意向排它锁、一致性锁定读与一致性非锁定读

2. [MySQL 备份详解](notes/MySQL_备份.md)

   备份类型、mysqldump 备份、mysqlpump 备份、Xtrabackup 备份、二进制日志备份

3. [MySQL 复制详解](notes/MySQL_复制.md)

   基于二进制日志的复制、基于 GTID 的复制、半同步复制、高可用架构 MMM 和 MHA 

4. [MySQL 高可用架构之 PXC 集群](notes/MySQL_PXC集群.md)

5. [MyCat 读写分离与分库分表](notes/MySQL_Mycat中间件.md)

6. [MySQL 查询性能分析之 Explain](notes/MySQL_EXPLAIN.md)

### Redis

1. [Redis 基本数据类型和常用命令](notes/Redis_数据类型和常用命令.md)

2. [Redis AOF 和 RDB 持久化策略原理](notes/Redis_持久化.md)

3. [Redis 哨兵模式](notes/Redis_哨兵模式.md)

   复制机制、哨兵模式架构说明、哨兵模式搭建

4. [Redis 集群模式](notes/Redis_集群模式.md)

   数据分区、节点通信、请求路由、故障发现与恢复、集群扩容与缩容
   
5. 使用 Redis 实现分布式锁


### MongoDB

1. [MongoDB 基础](notes/MongoDB_基础.md)

2. [MongoDB 索引](notes/MongoDB_索引.md)

   单字段索引、复合索引、多键索引、哈希所有、地理空间索引、文本索引；唯一索引、稀疏索引、部分索引、TTL 索引

3. [MongoDB 聚合](notes/MongoDB_聚合.md)

   常用聚合管道、单用途聚合方法、MapReduce

4. [MongoDB 复制](notes/MongoDB_复制.md)

   复制功能、故障发现、优先选举、投票成员、副本集搭建

5. [MongoDB 分片](notes/MongoDB_分片.md)

   分片副本集配置、配置副本集配置、路由服务配置

<br/>

## :whale: 系统与容器

1. [Linux 常用 Shell 命令](notes/Linux_常用Shell命令.md)

2. [Sehll 脚本编程基础](notes/Shell_基础.md)

   创建脚本、分支语句、循环语句、处理用户输入、处理用户输出、创建函数、处理信号、定时作业

3. [Docker 基础](notes/Docker_基础.md)

   核心概念（镜像、容器、仓库）、Docker 常用命令、DockerFile 常用指令

<br/>

##  :package: 常用技术栈


### RabbitMQ

1. [RabbitMQ 核心概念](notes/RabbitMQ_基础.md)

2. [RabbitMQ 客户端开发](notes/RabbitMQ_客户端开发.md)

3. [HAProxy + KeepAlived 搭建 RabbitMQ 高可用集群](notes/RabbitMQ_高可用集群架构.md)

### Nginx

1. [Nginx 基础之静态网站部署，负载均衡，动静分离](notes/Nginx_基础.md)
2. HTTP 模块详解
3. Nginx 性能优化


### Kafka

1. [Kafka 简介](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka简介.md)
2. [基于 Zookeeper 搭建 Kafka 高可用集群](https://github.com/heibaiying/BigData-Notes/blob/master/notes/installation/基于Zookeeper搭建Kafka高可用集群.md)
3. [Kafka 生产者详解](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka生产者详解.md)
4. [Kafka 消费者详解](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka消费者详解.md)
5. [深入理解 Kafka 副本机制](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka深入理解分区副本机制.md)


### ZooKeeper 

1. [ZooKeeper 简介及核心概念](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper简介及核心概念.md)
2. [ZooKeeper 单机环境和集群环境搭建](https://github.com/heibaiying/BigData-Notes/blob/master/notes/installation/Zookeeper单机环境和集群环境搭建.md) 
3. [ZooKeeper 常用 Shell 命令](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper常用Shell命令.md)
4. [ZooKeeper Java 客户端](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper_Java客户端Curator.md)
5. [ZooKeeper  ACL 权限控制](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper_ACL权限控制.md)
6. 使用 ZooKeeper 实现分布式锁

## ElasticSearch

TODO

<br/>

## :rocket: 测试与运维

1. 性能测试之 Jmeter
2. 性能测试之 LoadRunner
3. Jenkins 持续交付与自动化部署

<br/>

## :bullettrain_side: 微服务与分布式

1. 分布式锁的实现
2. 分布式选举算法
3. 分布式事务实现原理
4. 分布式全局 ID 的生成
5. CAP 理论和 BASE 理论

<br/>

##  :hammer_and_wrench: 常用软件安装

1. [Redis 单机环境安装](notes/installation/Redis单机环境搭建.md)
2. [RabbitMQ 单机环境安装](notes/installation/RabbitMQ单机环境搭建.md)
3. [Nginx 单机环境安装](notes/installation/Nginx编译方式安装.md)
4. [MySQL 单机环境安装](notes/installation/MySQL单机环境搭建.md)
5. [MongoDB 单机环境安装](notes/installation/MongoDB单机环境搭建.md)
6. [ElasticSearch + Kibana 单机环境安装](notes/installation/ElasticSearch+Kibana单机环境搭建.md)

<br>

<div align="center"> <img width="200px" src="pictures/blog-logo.png"/> </div>

<div align="center"> <a href = "https://blog.csdn.net/m0_37809146"> 欢迎关注我的博客：https://blog.csdn.net/m0_37809146</a> </div>

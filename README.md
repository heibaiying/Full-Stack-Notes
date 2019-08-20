#  :memo:全栈工程师笔记 

# :coffee: Java

1. Java 基础
2. GOF 23 种设计模式 (Java 语言实现)
3. 深入理解 Java 虚拟机
4. 无锁并行计算框架 Disruptor
6. 网络编程原理
6. Netty 编程模式

## 💻 前端

1. JavaScript 三座大山 —— 原型与原型链，作用域与闭包，异步与单线程
2. ECMAScript 6.0 核心知识

## 💾 数据库

### 1. Oracle



### 2. MySQL

+ [MySQL 基础](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MySQL_基础.md)
+ [MySQL 常用备份方式](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MySQL_备份.md)
+ [MySQL 二进制日志复制、GTID 复制与半同步复制](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MySQL_复制.md)
+ [MySQL 高可用架构之 PXC 集群](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MySQL_PXC集群.md)
+ [MyCat 分库分表](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MySQL_分库分表.md)
+ [MySQL 查询性能分析之 Explain](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MySQL_EXPLAIN.md)

### 3. Redis

+ [Redis 基本数据类型和常用命令](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Redis_数据类型和常用命令.md)
+ [Redis AOF 和 RDB 持久化策略原理](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Redis_持久化.md)
+ [Redis 哨兵模式](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Redis_哨兵模式.md)
+ [Reids 集群模式](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Redis_集群模式.md)

### 4.MongoDB

+ [MongoDB 基础](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MongoDB_基础.md)
+ [MongoDB 索引](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MongoDB_索引.md)
+ [MongoDB 聚合](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MongoDB_聚合.md)
+ [MongoDB 复制](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MongoDB_复制.md)
+ [MongoDB 分片](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/MongoDB_分片.md)

## 📟 操作系统

+ [Linux 常用 Shell 命令](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Linux常用Shell命令.md)



## 🌳 Spring

### 1.spring 基础

+ AOP
+ IOC
+ Spring事务机制、事务的传播与监控
+ ......

### 2.spring Boot

+ spring 自动装配原理
+ 理解 SpringApplication 
+ Web MVC REST 
+ WebFlux 核心
+ ......

## 🚀 分布式框架

### 1. Dubbo 

+ Dubbo 管理中心及监控平台安装部署
+ Dubbo 负载均衡和服务降级

### 2. Spring Cloud

- Eureka 服务的注册和发现
- Eureka 高可用集群搭建
- Ribbon 客户端负载均衡 RestTemplate 服务远程调用
- OpenFeign 声明式服务调用、服务容错处理
- Hystix 服务容错保护、Hystrix Dashboard 断路器监控、Turbine 断路器聚合监控
- Zuul 网关服务
- Sleuth + Zipkin 服务链路追踪
- Config 分布式配置中心 、集成 Bus 消息总线实现配置热更新

### 3.分布式解决方案

+ 全局 id 生成方案
+ 分布式 session 解决方案
+ 分布式事务解决方案实战
+ 分布式锁解决方案


## 中间件

### 1. 消息中间件：Kafka

1. [Kafka 简介](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka简介.md)
2. [基于 Zookeeper 搭建 Kafka 高可用集群](https://github.com/heibaiying/BigData-Notes/blob/master/notes/installation/基于Zookeeper搭建Kafka高可用集群.md)
3. [Kafka 生产者详解](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka生产者详解.md)
4. [Kafka 消费者详解](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka消费者详解.md)
5. [深入理解 Kafka 副本机制](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka深入理解分区副本机制.md)

### 2. 消息中间件：RabbitMQ

- [RabbitMQ 基础](https://github.com/heibaiying/BigData-Notes/blob/master/notes/RabbitMQ_基础.md)
- [RabbitMQ 客户端开发](https://github.com/heibaiying/BigData-Notes/blob/master/notes/RabbitMQ_客客户端开发.md)
- [基于 HAProxy + KeepAlived 搭建 RabbitMQ 高可用集群](https://github.com/heibaiying/BigData-Notes/blob/master/notes/RabbitMQ_高可用集群架构.md)

### 3.负载均衡中间件 Nginx

- Nginx 反向代理及负载均衡服务配置实战
- 利用 keeplived+Nginx 实现 Nginx 高可用方案
- Nginx 动静分离实战

### 4.分布式协调服务 Zookeeper 

1. [Zookeeper 简介及核心概念](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper简介及核心概念.md)
2. [Zookeeper 单机环境和集群环境搭建](https://github.com/heibaiying/BigData-Notes/blob/master/notes/installation/Zookeeper单机环境和集群环境搭建.md) 
3. [Zookeeper 常用 Shell 命令](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper常用Shell命令.md)
4. [Zookeeper Java 客户端 —— Apache Curator](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper_Java客户端Curator.md)
5. [Zookeeper  ACL 权限控制](https://github.com/heibaiying/BigData-Notes/blob/master/notes/Zookeeper_ACL权限控制.md)

## Docker

- [Docker 基础](https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Docker_基础.md)
- kubernetes  简介及集群搭建



## 📊 数据结构

数组、栈、队列、链表、二分搜索树、集合、映射、优先队列、堆、线段树、Trie、并查集、AVL、红黑树、哈希表



## 算法基础
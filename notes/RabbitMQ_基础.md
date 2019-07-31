# RabbitMQ 简介

## 一、简介

RabbitMQ 是目前最为广泛使用的开源消息中间件，它具备以下的特点：

支持多种消息传递协议，拥有丰富的交换器类型，能够将消息灵活路由到各个队列；

轻量级，支持多种部署方式，易于部署在公共云和私有云中；

支持跨语言开发，如：Java，.NET，PHP，Python，JavaScript，Ruby，Go；

可以通过集群来实现高可用性和高吞吐，还可以通过 Federation 插件来连接不同的服务；

插拔式的身份验证和授权，支持TLS和LDAP；

支持持续集成，能够使用各种工具和插件进行灵活地扩展；

能够使用多种方式进行监控和管理，如 HTTP-API，命令行工具和 UI 界面。

## 二、模型架构

![rabbitmq-架构](D:\Full-Stack-Notes\pictures\rabbitmq-架构.jpg)

### 2.1 核心概念

**1. Exchange（交换器）**

负责将消息路由到一个或者多个队列中。

**2. Queue（消息队列）**

用于存储消息。多个消费者可以订阅同一个消息队列，此时候队列中的消息会被平均分配给多个消费者进行处理。

**3. BindingKey (绑定键）**

交换器与队列通过 BindingKey 进行绑定。

**4. Routingkey (路由键）**

生产者将消息发给交换器的时候，一般会指定一个 RountingKey，用来指定这个消息的路由规则。当 RountingKey 与 BindingKey 在规则上相符合时，消息被路由到对应的队列中。

### 2.2 运转流程

**生产者发送消息过程**：

1. 生产者连接到RabbitMQ Broker , 建立一个连接（Connection）, 开启一个信道（Channel）；
2. 生产者声明一个交换器，并设置相关属性；
3. 生产者声明一个队列并设置相关属性；
4. 生产者通过路由键将交换器与队列绑定起来；
5. 生产者发送消息至 RabbitMQ Broker ，其中包含路由键、交换器等信息；
6. 相应的交换器根据接收到的路由键查找相应的匹配队列；
7. 如果找到，则将从生产者发送过来的消息存入相应的队列中；
8. 如果没有找到，则根据生产者配置的属性选择丢弃还是回退给生产者；
9. 关闭信道；
10. 关闭连接。

**消费者接收消息的过程**：

1. 消费者连接到 RabbitMQ Broker, 建立一个连接（Connection）, 开启一个信道（Channel）；
2. 消费者向 RabbitMQ Broker 请求消费相应队列中的消息，可能会设置相应的回调函数；
3. 等待 RabbitMQ Broker 回应并投递相应对列中的消息，消费者接收消息；
4. 消费者确认（ack）接收到的消息；
5. RabbitMQ 从队列中删除相应已经被确认的消息；
6. 关闭信道；
7. 关闭连接。

### 2.3 连接与信道

生产者和消费者都需要与 Broker 建立 TCP  连接，但由于创建和销毁 TCP 的操作非常昂贵，所以 RabbitMQ 采用了连接复用的方式，在同一个 TCP 连接上建立多个互相独立的信道。

## 三、交换器类型

### 3.1 fanout

把消息路由到与该交换器绑定的所有队列中。

### 3.2 direct

把消息路由到 BindingKey 和 RountingKey 完全一样的队列中。

### 3.3 topic

将消息路由到 BindingKey 和 RountingKey 相匹配的队列中，匹配规则如下：

- RountingKey 和 BindingKey 由多个单词使用`.`号进行连接；
- BindingKey 支持两个特殊符号：`#`和`*` 。其中`*`用于匹配一个单词，`#`用于匹配零个或者多个单词。

以下是官方文档中的示例，交换器与队列的 BindingKey  如图所示：

![topic-exchange](D:\Full-Stack-Notes\pictures\topic-exchange.png)

+ 路由键为`lazy.orange.elephant`的消息会发送给所有队列；
+ 路由键为`quick.orange.fox`的消息只会发送给第一个队列；
+ 路由键为`lazy.brown.fox`的消息只会发送给第二个队列；
+ 路由键为`lazy.pink.rabbit`的消息只会发送给第二个队列；
+ 路由键为`quick.brown.fox`的消息与任何绑定都不匹配；
+ 路由键为`orange`或`quick.orange.male.rabbit`的消息也与任何绑定都不匹配。

### 3.4 headers

在 Queue 与 Exchange 进行绑定时可以指定一组键值对作为 BindingKey；在发送消息的 headers 中的可以指定一组键值对属性，当这些属性与 BindingKey 相匹配时，则将消息路由到该队列。同时还可以使用 `x-match`指定匹配模式：

- **x-match = all** ：所有的键值对都相同才算匹配成功；
- **x-match = any**：只要有一个键值对相同就算匹配成功。

## 四、死信队列






# RabbitMQ 基础

## 一、消息队列

消息队列中间件 (Message Queue Middleware，简称 MQ) 是指利用高效可靠的消息传递机制进行与平台无关的数据交流，它可以在分布式环境下扩展进程间的数据通信，并基于数据通信来进行分布式系统的集成。它还可以运用于以下场景：

+ **项目解耦**：不同的项目或模块可以使用消息中间件进行数据的传递，从而可以保证模块的相对独立性，实现解耦。
+ **流量削峰**：可以将突发的流量 (如秒杀数据) 写入消息中间件，然后由多个消费者进行异步处理。
+ **弹性伸缩**：可以通过对消息中间件进行横向扩展来提高系统的处理能力和吞吐量。
+ **发布订阅**：可以用于需要进行数据的发布和订阅通知的场景。
+ **异步处理**：某些时候我们可能并不需要立即对数据进行处理，或者不关心处理的结果，此时可以使用中间件进行异步处理。
+ **冗余存储**：消息中间件可以对数据进行持久化存储，直到你消费完成后再进行删除。

## 二、AMQP协议

AMQP (Advanced Message Queuing Protocol) 是一个提供统一消息服务的应用层通讯协议，为消息中间件提供统一的开发规范。不同客户端可以将消息投递到中间件上，或从上面获取消息，发送消息和接收消息的客户端可以采用不同的语言开发、不同的技术实现，但必须遵循相同的 AMQP 协议。AMQP 协议本身包括以下三层：

- **Module Layer**：位于协议最高层，主要定义了一些供客户端调用的命令，客户端可以利用这些命令实现自己的业务逻辑。例如：可以使用 Queue.Declare 命令声明一个队列或者使用 Basic.Consume 订阅消费一个队列中的消息。 
- **Session Layer**：位于中间层，主要负责将客户端的命令发送给服务器，再将服务端的应答返回给客户端，主要为客户端与服务器之间的通信提供可靠性同步机制和错误处理。 
- **Transport Layer**：位于最底层，主要传输二进制数据流 ，提供帧的处理、信道复用、错误检测和数据表示等。 

## 三、RabbitMQ 简介

RabbitMQ 完全实现了 AMQP 协议，并基于相同的模型架构。RabbitMQ 在实现 `AMQP 0-9-1` 的基础上还进行了额外拓展，并可以通过插件来支持 `AMQP 1.0`。所以在某种程度上而言， RabbitMQ 就是 AMQP 在 Erlang 语言上的实现。RabbitMQ 基于众多优秀的特性成为了目前最为广泛使用的消息中间件，它的主要特性如下：

- 支持多种消息传递协议，除了 AMQP 外，还可以通过插件支持所有版本的 STOMP 协议和 MQTT 3.1 协议；
- 拥有丰富的交换器类型，可以满足绝大部分的使用需求；
- 支持多种部署方式，易于部署；

- 支持跨语言开发，如：Java，.NET，PHP，Python，JavaScript，Ruby，Go；

- 可以通过集群来实现高可用性和高吞吐，还可以通过 Federation 插件来连接不同的服务节点；

- 插拔式的身份验证和授权，支持 TLS 和 LDAP；

- 支持持续集成，能够使用各种插件进行灵活地扩展；

- 能够使用多种方式进行监控和管理，如 HTTP API，命令行工具和 UI 界面。


## 四、模型架构

![rabbitmq-架构](D:\Full-Stack-Notes\pictures\rabbitmq-架构.png)

### 1. Producer（生产者）

生产者负责生产消息并将其投递到指定的交换器上。

### 2. Message（消息）

消息由消息头和消息体组成。消息头用于存储元信息：如目标交换器的名字 (exchange_name) 、路由键 (RountingKey) 和其他可选配置 (properties) 等信息。消息体为实际需要传递的业务信息。

### 3. Exchange（交换器）

交换器负责接收来自生产者的消息，并将将消息路由到一个或者多个队列中，如果路由不到，则返回给生产者或者直接丢弃，这取决于交换器的 immediate 属性：

+ 当 mandatory 为 true 时：如果交换器无法根据自身类型和路由键找到一个符合条件的队列，则会将该消息返回给生产者；
+ 当 mandatory 为 false 时：如果交换器无法根据自身类型和路由键找到一个符合条件的队列，则会直接丢弃该消息。

### 4. BindingKey (绑定键）

交换器与队列通过 BindingKey 建立绑定关系。

### 5. Routingkey（路由键）

生产者将消息发给交换器的时候，一般会指定一个 RountingKey，用来指定这个消息的路由规则。当 RountingKey 与 BindingKey 基于交换器的类型相匹配时，消息被路由到对应的队列中。

### 6. Queue（消息队列）

用于存储路由过来的消息。多个消费者可以订阅同一个消息队列，此时候队列中的消息会被平均分配给多个消费者进行处理，而不是每个消费者都收到所有消息并处理。

### 7. Consumer（消费者）

消费者订阅感兴趣的队列，并负责消费存储在队列中的消息。为了保证消息能够从队列可靠的到达消费者，RabbitMQ 提供了消息确认机制 (message acknowledgement)，并通过 autoAck 参数来进行控制：

+ 当 autoAck 为 true 时：此时消息发送出去 (写入TCP套接字) 后就认为消费成功，而不管消费者是否真正消费到这些消息。当 TCP 连接或 channel 因意外而关闭，或者消费者在消费过程之中意外宕机，则对应的消息就丢失。因此这种模式可以提高吞吐量，但会存在数据丢失的风险。
+ 当 autoAck 为 false 时：需要用户在数据处理完成后进行手动确认，只有用户手动确认完成后，RabbitMQ 才认为这条消息已经被成功处理。这可以保证数据的可靠性投递，但会降低系统的吞吐量。

### 8. Connection（连接）

用于传递消息的 TCP 连接。

### 9. Channel（信道）

RabbitMQ 采用类似 NIO (非阻塞式 IO ) 的设计，通过 Channel 来复用 TCP 连接，并确保每个 Channel 的隔离性，就像拥有的是独立的 Connection 连接。当数据流量不是很大时，采用连接复用技术可以避免创建过多的 TCP 连接而导致昂贵的性能开销。

### 10. Virtual Host（虚拟主机）

RabbitMQ 支持多租户，并通过虚拟主机来实现逻辑分组和资源隔离，一个虚拟主机就是一个小型的 RabbitMQ 服务器，拥有独立的队列、交换器和绑定关系。用户可以按照不同业务场景建立不同的虚拟主机，虚拟主机之间是完全独立的，你无法将 vhost1 上的交换器与 vhost2 上的队列进行绑定，这可以极大的保证业务之间的隔离性和数据安全。默认的虚拟主机为 `/` 。

### 11. Broker

一个真实部署运行的 RabbitMQ 服务。

## 五、交换器类型

### 5.1 fanout

把消息路由到与该交换器绑定的所有队列中。

### 5.2 direct

把消息路由到 BindingKey 和 RountingKey 完全一样的队列中。

### 5.3 topic

将消息路由到 BindingKey 和 RountingKey 相匹配的队列中，匹配规则如下：

- RountingKey 和 BindingKey 由多个单词使用`.`号进行连接；
- BindingKey 支持两个特殊符号：`#`和`*` 。其中`*`用于匹配一个单词，`#`用于匹配零个或者多个单词。

以下是官方文档中的示例，交换器与队列的 BindingKey  如图所示：

![topic-exchange](D:\Full-Stack-Notes\pictures\topic-exchange.png)

+ 路由键为 `lazy.orange.elephant` 的消息会发送给所有队列；
+ 路由键为 `quick.orange.fox` 的消息只会发送给第一个队列；
+ 路由键为 `lazy.brown.fox` 的消息只会发送给第二个队列；
+ 路由键为 `lazy.pink.rabbit` 的消息只会发送给第二个队列；
+ 路由键为 `quick.brown.fox` 的消息与任何绑定都不匹配；
+ 路由键为 `orange` 或 `quick.orange.male.rabbit` 的消息也与任何绑定都不匹配。

### 5.4 headers

在 Queue 与 Exchange 进行绑定时可以指定一组键值对作为 BindingKey；在发送消息的 headers 中的可以指定一组键值对属性，当这些属性与 BindingKey 相匹配时，则将消息路由到该队列。同时还可以使用 `x-match`指定匹配模式：

- **x-match = all** ：所有的键值对都相同才算匹配成功；
- **x-match = any**：只要有一个键值对相同就算匹配成功。

## 六、死信队列

RabbitMQ 中另外一个比较常见的概念是死信队列。当消息在一个队列中变成死信 (dead message) 之后，它可以被重新被发送到另一个类型为 DLX 的交换器上。DLX 全称为 Dead-Letter-Exchange，即死信交换器，绑定 DLX 的队列就称之为死信队列。一个正常的消息变成死信一般是由于以下三个原因：

- 消息被拒绝 (Basic.Reject/Basic.Nack) ，井且设置重回队列的参数 requeue 为 false；
- 消息过期；
- 队列达到最大长度。 

我们可以通过在 channel.queueDeclare 方法中设置 x-dead-letter-exchange 参数来为指定队列添加 DLX，示例如下：

```java
// 创建一个死信交换器
channel.exchangeDeclare("some.exchange.name", "direct");

Map<String, Object> args = new HashMap<>();
args.put("x-dead-letter-exchange", "some.exchange.name");

// 为名为 myqueue 的队列指定死信交换器
channel.queueDeclare("myqueue", false, false, false, args);
```

除此之外，您还可以重新指定死信的路由键，如果没有指定，则默认使用原有的路由键，重新设置方法如下：

```shell
args.put("x-dead-letter-routing-key", "some-routing-key");
```



## 参考资料




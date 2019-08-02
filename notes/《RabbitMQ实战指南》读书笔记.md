# 《RabbitMQ实战指南》读书笔记

## 目录<br/>
<a href="#第一章-RabbitMQ的安装以及简单使用">第一章 RabbitMQ的安装以及简单使用</a><br/>
<a href="#第二章-RabbitMQ入门">第二章 RabbitMQ入门</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-相关概念介绍">2.1 相关概念介绍</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#211-生产者和消费者">2.1.1 生产者和消费者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#212-队列">2.1.2 队列</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#213-交换器、路由键、绑定">2.1.3 交换器、路由键、绑定</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#214-交换器类型">2.1.4 交换器类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#215-RabbitMQ运转流程">2.1.5 RabbitMQ运转流程</a><br/>
<a href="#第三章-客户端开发向导">第三章 客户端开发向导</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-连接RabbitMQ">3.1 连接RabbitMQ</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-使用交换器和队列">3.2 使用交换器和队列</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#321-exchangDeclare-方法详解">3.2.1 exchangDeclare 方法详解</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#322-queneDeclare方法详解">3.2.2 queneDeclare方法详解</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#323-queueBind方法详解">3.2.3 queueBind方法详解</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#324-exchangeBind方法详解">3.2.4 exchangeBind方法详解</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-发送消息（basicPublish）">3.3 发送消息（basicPublish）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-消费消息">3.4 消费消息</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#341-推模式">3.4.1 推模式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#342-拉模式">3.4.2 拉模式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#35-消费端的确认与拒绝">3.5 消费端的确认与拒绝</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#36-关闭连接">3.6 关闭连接</a><br/>
<a href="#第四章-RabbitMQ进阶">第四章 RabbitMQ进阶</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-消息何去何从">4.1 消息何去何从</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#411-mandatory-参数">4.1.1 mandatory 参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#412-immedidate-参数">4.1.2 immedidate 参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#413-备份交换器">4.1.3 备份交换器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-过期时间（TTL）">4.2 过期时间（TTL）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#421设置消息的TTL">4.2.1设置消息的TTL</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#422-设置队列的TTL">4.2.2 设置队列的TTL</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-死信队列DLX">4.3 死信队列DLX  </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#44-延迟队列">4.4 延迟队列</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#45-优先级队列">4.5 优先级队列</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#46-RPC-实现">4.6 RPC 实现</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#47-持久化">4.7 持久化</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#48-生产者确认">4.8 生产者确认</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#481-事务机制不推荐">4.8.1 事务机制(不推荐)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#482-发送方确认机制（推荐）">4.8.2 发送方确认机制（推荐）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#49-消费端要点介绍">4.9 消费端要点介绍</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#491-消息分发">4.9.1 消息分发</a><br/>
<a href="#第五章-RabbitMQ-管理">第五章 RabbitMQ 管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-虚拟主机与权限">5.1 虚拟主机与权限</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-用户管理">5.2 用户管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#53-web端管理">5.3 web端管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#54-应用与集群管理">5.4 应用与集群管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#541-应用管理">5.4.1 应用管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#542-集群管理">5.4.2 集群管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#55-服务端状态">5.5 服务端状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-队列状态">1. 队列状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-交换机状态">2. 交换机状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-绑定状态">3. 绑定状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-TCP|IP-连接状态">4. TCP|IP 连接状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-信道状态">5. 信道状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6消费者状态">6.消费者状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7Brokder的状态">7.Brokder的状态</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8其他状态">8.其他状态</a><br/>
## 正文<br/>





## 第一章 RabbitMQ的安装以及简单使用

**linux下安装步骤（docker）：**

1.docker pull rabbitmq:management

2.docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -v `pwd`/data:/var/lib/rabbitmq --hostname myRabbit -e RABBITMQ_DEFAULT_VHOST=my_vhost  -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin 镜像ID

说明：

- d 后台运行容器；
- name 指定容器名；
- p 指定服务运行的端口（5672：应用访问端口；15672：控制台Web端口号）；
- v 映射目录或文件；
- hostname  主机名（RabbitMQ的一个重要注意事项是它根据所谓的 “节点名称” 存储数据，默认为主机名）；
- e 指定环境变量；（RABBITMQ_DEFAULT_VHOST：默认虚拟机名；RABBITMQ_DEFAULT_USER：默认的用户名；RABBITMQ_DEFAULT_PASS：默认用户名的密码）

3.访问 http://宿主机地址:15672

**简单使用**：

```xml
# 引入依赖
<!-- https://mvnrepository.com/artifact/com.rabbitmq/amqp-client -->
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>5.2.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
```

```java
public class Rabbit {

    private static final String EXCHANGE_NAME="exchange-heibai";
    private static final String ROUTING_KEY="routingkey-heibai";
    private static final String QUEUE_NAME="queue-heibai";
    private static final String USER_NAME="heibai";
    private static final String PASSWORD="heibai";
    private static final String IP_ADDRESS="127.0.0.1";
    private static final int PORT=5672; //默认端口号


    @Test
    public void producer() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        // 获取新的连接
        Connection connection = factory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 创建一个 type="direct"、持久化的、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);
        // 创建一个持久化、非排他的、非自动删除的交换器
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        // 将交换器与队列通过路由键绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);
        String message="hello world";
        // 发送一条持久化的消息
        channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        // 关闭信道
        channel.close();
        // 关闭资源
        connection.close();
    }

    @Test
    public void consumer() throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = {new Address(IP_ADDRESS, PORT)};
        ConnectionFactory factory=new ConnectionFactory();
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        Connection connection = factory.newConnection(addresses);
        final Channel channel = connection.createChannel();
        // 设置客户端最多接收未被ack的消息的个数
        channel.basicQos(64);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 客户端接收后如何处理消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("rev message:"+new String(body));
                // 确认收到消息
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,consumer);
        // 等到回调函数完成后关闭连接
        TimeUnit.SECONDS.sleep(2);
        channel.close();
        connection.close();
    }

}
```

## 第二章 RabbitMQ入门

### 2.1 相关概念介绍

#### 2.1.1 生产者和消费者

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/RabbitMQ模型架构.png"/> </div></br>
<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/消息队列运转过程.png"/> </div></br>
#### 2.1.2 队列

**Queue（队列）** 是 RabbitMQ的内部对象，用于**存储消息**。多个消费者可以订阅同一个消息，这时候队列中的消息会被平均分摊（Round-Robin,即轮训）给多个消费者进行处理，而不是每个消费者都收到所有消费并处理。

#### 2.1.3 交换器、路由键、绑定

**Exchange（交换器）**：生产者将消息发送到Exchange（交换器），由交换器将消息路由到一个或者多个队列中。

**Routingkey (路由键)** ： 生产者将消息发给交换器的时候，一般会指定一个RountingKey，用来指定这个消息的路由规则。而这个RountingKey需要与交换器类型和绑定键（BindingKey）联合使用才能最终生效。

**Binding(绑定)**：RabbitMQ中通过绑定将交换器与队列关联起来，在绑定的时候一般会指定一个绑定键（BindingKey）,这样RabbitMQ就知道如何正确地将消息路由到队列。

#### 2.1.4 交换器类型

**1. fanout**: 把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中。

**2. direct**: 把消息路由到那些BindingKey和RountingKey 完全匹配的队列中。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/direct-exchange.png"/> </div></br>
**官方原文：**

In this setup, we can see the direct exchange X with two queues bound to it. The first queue is bound with binding key orange, and the second has two bindings, one with binding key black and the other one with green.

In such a setup a message published to the exchange with a routing key orange will be routed to queue Q1. Messages with a routing key of black or green will go to Q2. All other messages will be discarded.



**3. topic**:将消息路由到BindingKey和RountingKey 相匹配的队列中，匹配规则约定：

- RountingKey 和 BindingKey 均为一个点“.”分隔得字符串，被点号分隔得每一段独立的字符串称为一个单词。
- BindingKey 中可以存在两种特殊的字符串“#”和“*”，其中“\*”用于匹配一个单词，“\#”用于匹配零个或者多个单词。
  - \* (star) can substitute for exactly one word.
  - \# (hash) can substitute for zero or more words.

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/topic-exchange.png"/> </div></br>
官网原文对这一模式的说明比较清晰,摘抄如下：

We created three bindings: Q1 is bound with binding key "*.orange.*" and Q2 with "*.*.rabbit" and "lazy.#".

These bindings can be summarised as:

- Q1 is interested in all the orange animals.
- Q2 wants to hear everything about rabbits, and everything about lazy animals.

A message with a routing key set to "quick.orange.rabbit" will be delivered to both queues. Message "lazy.orange.elephant" also will go to both of them. On the other hand "quick.orange.fox" will only go to the first queue, and "lazy.brown.fox" only to the second. "lazy.pink.rabbit" will be delivered to the second queue only once, even though it matches two bindings. "quick.brown.fox" doesn't match any binding so it will be discarded.

What happens if we break our contract and send a message with one or four words, like "orange" or "quick.orange.male.rabbit"? Well, these messages won't match any bindings and will be lost.

On the other hand "lazy.orange.male.rabbit", even though it has four words, will match the last binding and will be delivered to the second queue.

**4. headers**

headers类型的交换器不依赖路由键的匹配规则来路由消息，而是根据发送的消息内容中的headers属性进行匹配。（不常用）

#### 2.1.5 RabbitMQ运转流程

**生产者发送消息过程**：

1. 生产者连接到RabbitMQ Broker, 建立一个连接（Connection）, 开启一个信道（Channel）；
2. 生产者声明一个交换器，并设置相关属性；
3. 生产者声明一个队列并设置相关属性；
4. 生产者通过路由键将交换器与队列绑定起来；
5. 生产者发送消息至RabbitMQ Broker ，其中包含路由键、交换器等信息；
6. 相应的交换器根据接收到的路由键查找相应的匹配队列；
7. 如果找到，则将从生产者发送过来的消息存入相应的队列中；
8. 如果没有找到，则根据生产者配置的属性选择丢弃还是回退给生产者；
9. 关闭信道；
10. 关闭连接。

**消费者接收消息的过程**：

1. 消费者连接到RabbitMQ Broker, 建立一个连接（Connection）, 开启一个信道（Channel）；
2. 消费者向RabbitMQ Broker请求消费相应队列中的消息，可能会设置相应的回调函数；
3. 等待RabbitMQ Broker回应并投递相应对列中的消息，消费者接收消息；
4. 消费者确认（ack）接收到的消息；
5. RabbitMQ从队列中删除相应已经被确认的消息；
6. 关闭信道；
7. 关闭连接。

## 第三章 客户端开发向导

### 3.1 连接RabbitMQ

```java
// 1. 给定参数连接
ConnectionFactory factory = new ConnectionFactory();
factory.setHost(IP_ADDRESS);
factory.setPort(PORT);
factory.setVirtualHost("/");
factory.setUsername(USER_NAME);
factory.setPassword(PASSWORD);
Connection connection = factory.newConnection();

// 2.url 连接
ConnectionFactory factory new ConnectionFactory();
factory.setUri( "amqp://userName:password@ipAddress:portNumber/virtualHost");
Connection conn = factory.newConnection();
```

**注**:Connection 可以 用来创建多个 Channel 实例，但是 Channel 实例不能在线程问共享，应用程序应该为每一个线程开辟一个 Channel 。 

### 3.2 使用交换器和队列

```java
// 创建一个 type="direct"、持久化的、非自动删除的交换器
channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);
// 创建一个持久化、非排他的、非自动删除的队列
channel.queueDeclare(QUEUE_NAME,true,false,false,null);
// 将交换器与队列通过路由键绑定
channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);
```

#### 3.2.1 exchangDeclare 方法详解

**1.声明交换器**

```java
/**
* Declare an exchange.

* @param exchange the name of the exchange
  交换器的名称

* @param type the exchange type
  交换器的类型，fanout,direct,topic 等

* @param durable true if we are declaring a durable exchange (the exchange will survive a server restart)
  设置是否持久化，持久化可以将交换器存盘，在服务器重启的时候不会丢失相关的信息

* @param autoDelete true if the server should delete the exchange when it is no longer in use
  是否自动删除，自删除的前提是至少有一个队列或者交换器与这交换器绑定,之后所有与这个交换器绑定的队列或者交换器都与此解绑后删除,一般都设置为fase

* @param internal true if the exchange is internal, i.e. can't be directly
  internal是否内置,如果设置 为true,则表示是内置的交换器,客户端程序无法直接发送消息到这个交换器中,只能通过交换器路由到交换器的方式

* @param arguments other properties (construction arguments) for the exchange
  arguments:其它一些结构化参数比如:alternate-exchange
  
* @return a declaration-confirm method to indicate the exchange was successfully declared
* @throws java.io.IOException if an error is encountered
     */
Exchange.DeclareOk exchangeDeclare(String exchange,
                                              String type,
                                              boolean durable,
                                              boolean autoDelete,
                                              boolean internal,
                                              Map<String, Object> arguments) throws IOException;
```

**2.检测交换器是否存在**

```java
/**
* Declare an exchange passively; that is, check if the named exchange exists.
* @param name check the existence of an exchange named this
* @throws IOException the server will raise a 404 channel exception if the named exchange does not exist.
它主要用来检测相应的交换器是否存在。如果存在则正常返回:如果不存在则抛出异常 : 404 channel exception。
*/
Exchange.DeclareOk exchangeDeclarePassive(String name) throws IOException;
```

**3. 删除交换器** 

```java
/**
* Delete an exchange
* @param exchange the name of the exchange
* @param ifUnused true to indicate that the exchange is only to be deleted if it is unuse
 ifUnused 用来设置是否在交换器没有被使用的情况下删除 。 如果 isUnused 设置为 true，则只有在此交换器没有被使用的情况下才会被删除;如果设置 false，则无论如何这个交换器都要被删除。
* @return a deletion-confirm method to indicate the exchange was successfully deleted
* @throws java.io.IOException if an error is encountered
*/
Exchange.DeleteOk exchangeDelete(String exchange, boolean ifUnused) throws IOException;
```

#### 3.2.2 queneDeclare方法详解

queneDeclare只有两个重载方法：

不带任何参数的 queueDeclare 方法默认创建一个由 RabbitMQ 命名的(类似这种amq.gen-LhQzlgv3GhDOv8PIDabOXA 名称，这种队列也称之为匿名队列〉、排他的、自动删除的、非持久化的队列。 

```java
/**
* Declare a queue
* @param queue the name of the queue
  队列的名称。
* @param durable true if we are declaring a durable queue (the queue will survive a server restart)
  是否持久化
* @param exclusive true if we are declaring an exclusive queue (restricted to this connection)
* @param autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
  是否自动删除 自动删除的前提是:至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时，才会自动删除。
* @param arguments other properties (construction arguments) for the queue
* @return a declaration-confirm method to indicate the queue was successfully declared
* @throws java.io.IOException if an error is encountered
*/
Queue.DeclareOk queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete,
                                 Map<String, Object> arguments) throws IOException;
```

exclusive : 设置是否排他。为 true 则设置队列为排他的。如果一个队列被声明为排他队列，该队列仅对首次声明它的连接可见，并在连接断开时自动删除。这里需要注意三点:

- 排他队列是基于连接( Connection) 可见的，同一个连接的不同信道 (Channel)是可以同时访问同一连接创建的排他队列; 
- "首次"是指如果一个连接己经声明了 一个排他队列，其他连接是不允许建立同名的排他队列的，这个与普通队列不同；
- 即使该队列是持久化的，一旦连接关闭或者客户端退出，该排他队列都会被自动删除，这种队列适用于一个客户端同时发送和读取消息的应用场景。 

注：

生产者和消费者都能够使用 queueDeclare 来声明一个队列，但是如果消费者在同一个信道上订阅了另一个队列，就无法再声明队列了。必须先取消订阅，然后将信道直为"传输" 模式，之后才能声明队列。 

**清空队列内容**：

```java
Queue.PurgeOk queuePurge(String queue) throws IOException;
```

#### 3.2.3 queueBind方法详解

**用于交换器与队列的绑定**

```java
# 绑定
Queue.BindOk queueBind(String queue, String exchange, String routingKey, Map<String, Object> arguments) throws IOException;

# 解绑
Queue.UnbindOk queueUnbind(String queue, String exchange, String routingKey, Map<String, Object> arguments) throws IOException;
```

#### 3.2.4 exchangeBind方法详解

**用于交换器与交换器的绑定**

```java
Exchange.BindOk exchangeBind(String destination, String source, String routingKey, Map<String, Object> arguments) throws IOException;
```

生产者发送消息至交换器 source 中，交换器 source 根据路由键找到与其匹配的另一个交换器 destination ， 井把消息转发到 destination 中 ， 进而存储在 destination 绑定 的队列 queue 中 。

### 3.3 发送消息（basicPublish）

补充：Java 8 对接口做了进一步的增强。

- **a.** 在接口中可以添加使用 default 关键字修饰的非抽象方法。即：默认方法（或扩展方法）
- **b.** 接口里可以声明静态方法，并且可以实现。

```java
void basicPublish(String exchange, String routingKey, boolean mandatory, boolean immediate, 						BasicProperties props, byte[] body) throws IOException;
```

- exchange: 交换器的名称，指明消息需要发送到哪个交换器中 。 **如果设置为空字符串，则消息会被发送到 RabbitMQ 默认的交换器中**;
- props : 消息的基本属性集;
- byte [] body : 消息体 ( payload ) ，真正需要发送的消息 。 

```java
// 发送一条持久化的消息
channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        
// 发送一条特殊配置的消息
channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,
                        new AMQP.BasicProperties.Builder()
                        .contentType("text/plain")
                        .deliveryMode(2)
                        .priority(1)
                        .headers(new HashMap<String, Object>())
                        .expiration("6000")
                        .build(),
                        message.getBytes());
```

### 3.4 消费消息

#### 3.4.1 推模式

在推模式中，可以通过持续订阅的方式来消费消息。接收消息一般通过实现**Consumer**接口或者继承**DefaultConsumer**类来实现。当调用与Consumer相关的API方法时，不同的订阅采用不同的消费者标签（consumerTag）来区分彼此，在同一个Channel中的消费者也需要通过唯一的消费者标签以作区分。

```java
channel.basicConsume(QUEUE_NAME,false,"myConsumerTag",new DefaultConsumer(channel) {
            // 客户端接收后处理消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties 				properties, byte[] body) throws IOException {
                System.out.println("rev message:"+new String(body));
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();
                // 确认收到消息
                channel.basicAck(envelope.getDeliveryTag(),false);
                // 或者拒绝消息 一次只能拒绝一条
                channel.basicReject(deliveryTag,true);
                // 一次拒绝多条
                channel.basicNack(deliveryTag,true,true);
            }
        });

```

```java
String basicConsume(String queue, boolean autoAck, String consumerTag, boolean noLocal, boolean 	  exclusive, Map<String, Object> arguments, Consumer callback) throws IOException;
```

- queue : 队列的名称:
- autoAck : 设置是否自动确认。建议设成 false ，即不自动确认:
- consumerTag: 消费者标签，用来区分多个消费者:
- noLocal : 设置为 true 则表示不能将同一个 Connection中生产者发送的消息传送给这个 Connection 中的消费者:
- exclusive : 设置是否排他 :
- arguments : 设置消费者的其他参数:
- callback : 设置消费者的回调函数。用来处理 RabbitMQ 推送过来的消息，比如DefaultConsumer ， 使用时需要客户端重写 (override) 其中的方法。 

**注**:

每个 Channel 都拥有自己独立的线程。最常用的做法是一个 Channel 对应一个消费者，也就是意味着消费者彼此之间没有任何关联。当然也可以在一个 Channel 中维持多个消费者，但是要注意一个问题，如果 Channel 中的一个消费者一直在运行，那么其他消费者的 callback会被"耽搁"。 

#### 3.4.2 拉模式

通过channel.basicGet方法可以单挑获取信息。

```java
GetResponse response = channel.basicGet(QUEUE_NAME, false);
System.out.println(new String(response.getBody()));
channel.basicAck(response.getEnvelope().getDeliveryTag(),false);
```

**注**：

Basic . Consume 将信道 (Channel) 直为接收模式，直到取消队列的订阅为止。在接收模式期间， RabbitMQ 会不断地推送消息给消费者，当然推送消息的个数还是会受到 Basic.Qos的限制.如果只想从队列获得单条消息而不是持续订阅，建议还是使用Basic.Get 进行消费. 

### 3.5 消费端的确认与拒绝

**1.确认**

为了保证消息从队列可靠地达到消费者， RabbitMQ 提供了消息确认机制( messageacknowledgement) 。 消费者在订阅队列时，可以指定 aut oAck 参数：

**当 autoAck 等于 false时， RabbitMQ 会等待消费者显式地回复确认信号后才从内存(或者磁盘)中移去消息(实质上是先打上删除标记，之后再删除) 。**

**当 autoAck 等于 true 时， RabbitMQ 会自动把发送出去的消息置为确认，然后从内存(或者磁盘)中删除，而不管消费者是否真正地消费到了这些消息 。**

采用消息确认机制后，只要设置 autoAck 参数为 false，消费者就有足够的时间处理消息(任务) ，不用担心处理消息过程中消费者进程挂掉后消息丢失的问题 ， 因为 RabbitMQ 会一直等待持有消息直到消费者显式调用 Basic.Ack 命令为止 。
当 autoAck 参数置为 false ，对于 RabbitMQ 服务端而言 ，队列中的消息分成了两个部分 :一部分是等待投递给消费者的消息:一部分是己经投递给消费者，但是还没有收到消费者确认信号的消息。 如果 RabbitMQ 一直没有收到消费者的确认信号，并且消费此消息的消费者己经断开连接，则 RabbitMQ 会安排该消息重新进入队列，等待投递给下一个消费者，当然也有可能还是原来的那个消费者。 

RabbitMQ 不会为未确认的消息设置过期时间，它判断此消息是否需要重新投递给消费者的唯一依据是消费该消息的消费者连接是否己经断开，这么设计的原因是 RabbitMQ 允许消费者消费一条消息的时间可以很久很久。 

**2.拒绝**

```java
// 一次拒绝一条 
void basicReject(long deliveryTag, boolean requeue) throws IOException;

// 一次拒绝多条
 void basicNack(long deliveryTag, boolean multiple, boolean requeue)
            throws IOException;
```

其中 deliveryTag 可以看作消息的编号  。如果 requeue 参数设置为 true ，则 RabbitMQ 会重新将这条消息存入队列，以便可以发送给下一个订阅的消费者;如果 requeue 参数设置为 false，则 RabbitMQ立即会把消息从队列中移除，而不会把它发送给新的消费者。

multiple 参数设置为 false 则表示拒绝编号为 deliveryTag的这 一条消息，这时候 basicNack 和basicReject 方法一样; multiple 参数设置为 true 则表示拒绝 deliveryTag 编号之前所有未被当前消费者确认的消息。  

**3.重入队列**

```java
Basic.RecoverOk basicRecover() throws IOException;
Basic.RecoverOk basicRecover(boolean requeue) throws IOException;
```

这个 channel.basicRecover 方法用来请求 RabbitMQ 重新发送还未被确认的消息 。 如果 requeue 参数设置为 true ，则未被确认的消息会被重新加入到队列中，这样对于同一条消息来说，可能会被分配给与之前不同的消费者。如果 requeue 参数设置为 false，那么同一条消息会被分配给与之前相同的消费者。默认情况下，如果不设置 requeue 这个参数，相当channel.basicRecover(true) ，即 requeue 默认为 true。 

### 3.6 关闭连接

在应用程序使用完之后，需要关闭连接，释放资源:
channel.close();
conn.close() ; 

## 第四章 RabbitMQ进阶

### 4.1 消息何去何从

mandatory 和 immediate 是 channel.basicPublish 方法中的两个参数，它们都有**当消息传递过程中不可达目的地时将消息返回给生产者的功能**。 RabbitMQ 提供的备份交换器(Altemate Exchange) 用以将未能被交换器路由的消息(没有绑定队列或者没有匹配的绑定〉存储起来，而不用返回给客户端。 

#### 4.1.1 mandatory 参数

当 mandatory 参数设为 true 时，**交换器无法根据自身的类型和路由键找到一个符合条件的队列**，那么 RabbitMQ 会调用 Basic.Return 命令将消息返回给生产者 。

当 mandatory 参数设置为 false 时，出现上述情形，则消息直接被丢弃 。 

那么生产者如何获取到没有被正确路由到合适队列的消息呢? **可以通过调用channel . addReturnListener 来添加 ReturnListener 监昕器实现**。 

```java
channel.addReturnListener(new ReturnListener() {
            public void handleReturn(int replyCode, String replyText, String exchange, String 					routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Basic.Return返回的结果是："+message);
            }
        });
```

#### 4.1.2 immedidate 参数

当 immediate 参数设为 true 时，如果交换器在**将消息路由到队列时发现队列上并不存在任何消费者**，那么这条消息将不会存入队列中。当与路由键匹配的所有队列都没有消费者时 ，该消息会通过 Basic . Return 返回至生产者。 

**RabbitMQ 3 .0 版本因为性能开始去掉了对 imrnediate 参数的支持** 

#### 4.1.3 备份交换器

备份交换器，可以将未被路由的消息存储在 RabbitMQ 中，再在需要的时候去处理这些消息。 

可以通过在声明交换器(调用 channel.exchangeDeclare 方法)的时候添加**alternate-exchange** 参数来实现 

```java
// 声明备份交换器 最好将type类型设置为 fanout
channel.exchangeDeclare( "myAe " , "fanout" , true, false , null) ;

// 声明正常交换器 并设置备份交换器为myAe
Map<String, Object> args = new HashMap<String, Object>();
args.put("a1ternate-exchange" , "myAe");
channel.exchangeDeclare( "normalExchange" , "direct" , true , false , args);

// 声明队列并和交换器绑定
channel.queueDeclare( "norma1Queue " , true , false , false , null);
channel.queueBind( " norma1Queue " , " normalExchange" , " norma1Key");
channel.queueDeclare( "unroutedQueue " , true , false , false , null);
channel.queueBind( "unroutedQueue ", "myAe ", "");
```

**特殊情况**：

- 如果设置的备份交换器不存在，客户端和 RabbitMQ 服务端都不会有异常出现，此时消息会丢失。
- 如果备份交换器没有绑定任何队列，客户端和 RabbitMQ 服务端都不会有异常出现，此时消息会丢失。
- 如果备份交换器没有任何匹配的队列，客户端和 RabbitMQ 服务端都不会有异常出现，此时消息会丢失。
- 如果备份交换器和 mandatory 参数一起使用，那么 mandatory 参数无效。 

### 4.2 过期时间（TTL）

#### 4.2.1设置消息的TTL

- 第一种方法是通过队列属性设置，队列中所有消息都有相同的过期时间。
- 第二种方法是对消息本身进行单独设置，每条消息的 TTL 可以不同。
- 两种方法一起使用，则消息的 TTL 以两者之间较小的那个数值为准。
- 消息在队列中的生存时司 一旦超过设置 的 TTL 值时，就会变成"死信" (Dead Message) ，消费者将无法再收到该消息(这点不是绝对的 ，可以参考 4.3 节) 。 

**1.通过队列属性设置消息 TTL 的方法是在 channel.queueDeclare 方法中加入 x-message-ttl 参数实现的，这个参数的单位是毫秒。**

```java
Map<String, Object> argss = new HashMap<String , Object>();
argss.put("x-message-ttl " , 6000);
channel.queueDeclare(queueName , durable , exclusive , autoDelete , argss) ;
```

**2.针对每条消息设置 TTL 的方法是在 channel.basicPublish 方法中加入 expiration 的属性参数，单位为毫秒。** 

采用这种方法设置，一旦消息过期，就会从队列中抹去 。

注：如果不设置 TTL.则表示此消息不会过期 ;如果将 TTL 设置为 0，则表示除非此时可以直接将消息投递到消费者，否则该消息会被立即丢弃。

```java
AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
builder.deliveryMode(2); // 持久化消息
builder.expiration( " 60000 " );// 设置 TTL=60000ms
AMQP.BasicProperties properties = builder . build() ;
channel.basicPublish(exchangeName, routingKey, mandatory, properties,"ttlTestMessage".getBytes());
```

#### 4.2.2 设置队列的TTL

通过 channel . queueDeclare 方法中的 x - expires 参数可以控制队列被自动删除前处于未使用状态的时间。未使用的意思是队列上没有任何的消费者，队列也没有被重新声明，并且在过期时间段 内也未调用过 Basic.Get 命令。 RabbitMQ 会确保在过期时间到达后将队列删除，但是不保障删除的动作有多及时 。在RabbitMQ 重启后 ， 持久化的队列的过期时间会被重新计算。 

**用于表示过期时间的 x-expires 参数以毫秒为单位 ， 井且服从和 x-message-ttl 一样的约束条件，不过不能设置为 0。比如该参数设置为 1000 ，则表示该队列如果在 1 秒钟之内未使用则会被删除。** 

```java
Map<String, Object> args =new HashMap<String, Object>() ;
args.put( "x-expires" , 1800000);
channel.queueDeclare("myqueue " , false , false , false , args) ;
```

### 4.3 死信队列DLX  

当有队列中存在死信时,RabbitMQ 就会自动地将这个消息重新发布到设置的 DLX 上去 。 

**消息变成死信一般是由于以下几种情况**:

- 消息被拒绝 (Basic.Reject/Basic.Nack) ，井且设置 requeue 参数为 false;
- 消息过期;
- 队列达到最大长度。 

**通过在 channel.queueDeclare 方法中设置 x-dead-letter-exchange 参数来为这个队列添加 DLX**  

```java
 //创建 DLX: dlx_exchange
 channel.exchangeDeclare("dlx_exchange " , "direct ");
 Map<String, Object> args = new HashMap<String, Object>();
 args.put("x-dead-letter-exchange" , " dlx_exchange ");
 //也可以为这个 DLX 指定路由键，如果没有特殊指定，则使用原队列的路由键:
 args.put("x-dead-letter-routing-key" , "dlx-routing-key");
 //为队列 myqueue 添加 DLX
 channel.queueDeclare("myqueue" , false , false , false , args);
```

```java
  // 声明用于DXL队列的交换器
  channel.exchangeDeclare("exchange.dlx", "direct", true);
  // 声明正常交换器
  channel.exchangeDeclare("exchange.normal ", "fanout ", true);
  // 为正常队列绑定DXL交换器
  Map<String, Object> args = new HashMap<String, Object>();
  args.put("x-message - ttl ", 10000);
  args.put("x-dead-letter-exchange ", "exchange.dlx"); //DXL队列与DXL交换器的原路由键
  args.put("x-dead-letter-routing-key", " routingkey");
  channel.queueDeclare(" queue.norma1 ", true, false, false, args);
  // 正常队列与正常交换器绑定
  channel.queueBind("queue.normal", "exchange.normal", "");
  // 声明DXL队列
  channel.queueDeclare(" queue.d1x ", true, false, false, null);
  // DXL队列与信DXL交换器绑定
  channel.queueBind("queue.dlx ", "exchange.dlx ", "routingkey");
  // 发送一条信息 10s超时后成为死信
  channel.basicPublish("exchange.normal", " rk",
  MessageProperties.PERSISTENT_TEXT_PLAIN, "message".getBytes());
```

### 4.4 延迟队列

利用死信队列来实现：

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/延迟队列.png"/> </div></br>
### 4.5 优先级队列

**设置队列优先级**：

```java
Map<String, Object> args = new HashMap<String, Object>();
args.put("x-max-priority ", 10);
channel.queueDeclare(" queue . priority", true, false, false, args);
```

**设置消息优先级**：

```java
AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
builder.priority(5);
AMQP.BasicProperties properties = builder.build();
channel.basicPublish("exchange_priority", " rk_priority ", properties, "message".getBytes());
```

### 4.6 RPC 实现

Java版本可参考博客：https://blog.csdn.net/u013256816/article/details/55218595

python版本可参考官网：http://www.rabbitmq.com/tutorials/tutorial-six-python.html

### 4.7 持久化

**交换器的持久化**：通过在声明队列是将 durable 参数置为 true 实现的；

**队列的持久化**：是通过在声明队列时将 durable 参数置为 true 实现的；  

**消息的持久化** ：通过将消息的投递模式(BasicProperties中的 deliveryMode 属性) 设置为 2 即可实现

### 4.8 生产者确认

当消息的生产者将消息发送出去之后，消息到底有没有正确地到达服务器呢? RabbitMQ 针对这个问题，提供了两种解决方式:

- 通过事务机制实现:
- 通过发送方确认 C publisher confirm ) 机制实现。 

#### 4.8.1 事务机制(不推荐)

RabbitMQ 客户端中与事务机制相关的方法有 三个:

- **channel.txSelect** 用于将当前的信道设置成事务模式;
- **channel.txCommit** 用于提交事务 ;
- **channel.txRollback** 用于事务回滚。 

```java
// 單條消息
try {
    channel.txSelect();
    channel.basicPublish(exchange, routekey, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
    int result = 1 / 0;
    channel.txCommit();
} catch (Exception e) {
    e.printStackTrace();
    channel.txRollback();
} 
 
//多條消息
channel.txSelect();
for (int i = 0; i < NUM; i++) {
    try {
        channel.basicPublish(exchange, routekey, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
        channel.txCommit();
    } catch (Exception e) {
        e.printStackTrace();
        channel.txRollback();
    }
}
```

#### 4.8.2 发送方确认机制（推荐）

生产者将信道设置成 confirm（确认)模式，一旦信道进入 confirm模式，所有在该信道上面发布的消息都会被指派一个唯一的ID(从 1开始)，一旦消息被投递到所有匹配的队列之后，RabbitMQ 就会发送一个确认(Basic.Ack) 给生产者(包含消息的唯一 ID) ，这就使得生产者知晓消息已经正确到达了目的地了。 

```java
try {
 // 将信到置为 publisher confirm 模式  
 channel.confirmSelect();  hannel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
    // 这样意味着还是同步阻塞的 性能并不比事务方式好（不推荐）
 if (!channel.waitForConfirms()){
 	System.out.println("send message failed");
 	// do something else ...
 	}
 } catch (Exception e) {
 e.printStackTrace();
}
```

**异步confirm模式**（推荐）：的编程实现最复杂，Channel对象提供的ConfirmListener()回调方法只包含deliveryTag（当前Chanel发出的消息序号），我们需要自己为每一个Channel维护一个unconfirm的消息序号集合，每publish一条数据，集合中元素加1，每回调一次handleAck方法，unconfirm集合删掉相应的一条（multiple=false）或多条（multiple=true）记录。从程序运行效率上看，这个unconfirm集合最好采用有序集合SortedSet存储结构。

**注：不论是handleAck还是handleNack都证明消息被收到了，并没有丢失。**

```java
SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if (multiple) {
                    confirmSet.headSet(deliveryTag + 1).clear();
                } else {
                    confirmSet.remove(deliveryTag);
                }
            }

            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("Nack, SeqNo: " + deliveryTag + ", multiple: " + multiple);
                if (multiple) {
                    confirmSet.headSet(deliveryTag + 1).clear();
                } else {
                    confirmSet.remove(deliveryTag);
                }
                // 添加消息重发逻辑
            }
        });
        while (true) {
            long nextSeqNo = channel.getNextPublishSeqNo();
            channel.basicPublish(ConfirmConfig.exchangeName, ConfirmConfig.routingKey, 	MessageProperties.PERSISTENT_TEXT_PLAIN, ConfirmConfig.msg_10B.getBytes());
            // 将需要发送消息的id放入Set中
            confirmSet.add(nextSeqNo);
        }
```

### 4.9 消费端要点介绍

#### 4.9.1 消息分发

**channel.basicQos 方法允许限制信道上的消费者所能保持的最大未确认消息的数量。**



## 第五章 RabbitMQ 管理

rabbitmqctl 标准语法([] 表示可选参数，{} 表示必选参数)：

rabbitmqctl [-n node] \[-t timeout] [-q] \{command} [command options...]

- **[-n node]**：指定节点；
- **[-t timeout]**：操作超时时间，单位秒；
-  **[-q]** ：quiet 屏蔽一些消息的输出，默认不开启。

### 5.1 虚拟主机与权限

**虚拟主机：**

| 作用         | 命令                                                         | 示例                                 |
| ------------ | ------------------------------------------------------------ | ------------------------------------ |
| 新建虚拟主机 | rabbitmqctl  add_vhost {vhost}                               | rabbitmqctl  add_vhost  vhost1       |
| 罗列虚拟主机 | rabbitmqctl  list_vhosts [vhostinfoitem...]<br/>name：表示vhost 名称<br/>tracing:表示是否启用了RabbitMQ的trace功能 | abbitmqctl  list_vhosts name tracing |
| 删除虚拟主机 | rabbitmqctl delete_vhost {vhost}                             | rabbitmqctl delete_vhost  vhost1     |

**权限管理**：

当创建一个用户时，用户通常会被指派给至少一个vhost,并且只能访问被指派的vhost内的队列、交换器和绑定关系等。因此，RabbitMQ中的授予权限是指在vhost级别对用户而言的权限授予。

| 作用               | 命令                                                         | 示例                                                         |
| ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 权限授予           | rabbitmqctl  set_permissions [-p vhost] {user} {config} {write} {read}<br/>vhost : 授予用户访问权限的 vhost 名称，可以设置为默认值，即 vhost 为 “/”<br/>user: 可以访问指定 vhost 的用户名。<br>conf: 一个用于匹配用户在哪些资源上拥有可配置权限的正则表达式。<br/>write: 一个用于匹配用户在哪些资源上拥有可写权限的正则表达式。<br/>read : 一个用于匹配用户在哪些资源上拥有可读权限的正则表达式 。<br/>可配置指的是队列和交换器的创建及删除之类的操作;可写指的是发布消息;可读指与消息有关的操作，包括读取消息及清空整个队列等。 | 赋予所有权限:<br>rabbitmqctl set_permissions -p vhost1 root ".\*"  ".\*"  ".\*"<br>在以“queue”开头的资源上具备可配置权限：<br>rabbitmqctl set_permissions -p vhost1 root "^queue.\*"  ".\*"  ".\*" |
| 清除权限           | rabbitmqctl clear_permissions [-p vhost] {username}          | rabbitmqctl clear_permissions -p vhost1 root                 |
| 显示虚拟机上的权限 | rabbitmqctl list_permissions [-p vhost]                      | rabbitmqctl list_permissions -p vhost1                       |
| 显示用户权限       | rabbitmqctl list_user_permissions {username}                 | rabbitmqctl list_user_permissions root                       |

### 5.2 用户管理

| 作用               | 命令                                                         |
| ------------------ | ------------------------------------------------------------ |
| 创建用户           | rabbitmqctl  add_user {username} {password}                  |
| 更改密码           | rabbitmqctl change_password {username}  {newpassword}        |
| 验证密码是否正确   | rabbitmqctl authenticate_user {username} {password}          |
| 删除用户           | rabbitmqctl delete_user {username}                           |
| 罗列当前的所有用户 | rabbitmqctl list_users                                       |
| 设置用户角色       | rabbitmqctl set_user_tags {username} {tag ...} <br/>设置0个、1个或者多个角色，设置之后任何之前现有的身份都会被删除 |

用户的角色分为 5 种类型：

- **none**: 无任何角色。新创建的用户的角色默认为 none。
- **management**: 可以访问 Web 管理页面。
- **policymaker**: 包含 management 的所有权限，并且可以 管理策略 ( Policy) 和参数(Parameter)。
- **monitoring**: 包含 management 的所有权限，并且可以看到所有连接、信道及节点相关的信息。
- **administartor**: 包含 monitoring 的所有权限，井且可以管理用户、 虚拟主机、权限、策略、参数等，是最高权限。

### 5.3 web端管理

在使用 Web 管理界面之前需要先启用 RabbitMQ management 插件 。 RabbitMQ 提供了很多的插件，默认存放在 $RABBITMQ_HOME /plugins 目录下 ，插件扩展名为“.ez”。

| 作用     | 命令                                   |
| -------- | -------------------------------------- |
| 启动插件 | rabbitmq-plugins enable [plugin-name]  |
| 关闭插件 | rabbitmq-plugins disable [plugin-name] |
| 查看插件 | rabbitmq-plugins list                  |

### 5.4 应用与集群管理

#### 5.4.1 应用管理

| 命令                             | 作用                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| rabbitmqctl stop [pid_file]      | 用于停止运行 RabbitMQ 的 Erlang 虚拟机和 RabbitMQ 服务应用。<br/>如果指定了 pid_file ,还需要等待指定进程的结束。其中 pid file 是通过调用 rabbitmq-server 命令启动RabbitMQ 服务时创建的，默认情况下存放于Mnesia 目录中，可以通过 RABBITMQ_PID_FILE这个环境变量来改变存放路径。注意，如果使用 rabbitmq-server -detach 这个带有-detach 后缀的命令来启动 RabbitMQ 服务则不会生成 pid file 文件。 |
| rabbitmqctl shutdown             | 用于停止运行 RabbitMQ 的 Erlang 虚拟机和 RabbitMQ 服务应用。执行这个命令会阻塞直到 Erlang 虚拟机进程退出。 |
| rabbitmqctl stop_app             | 停止 RabbitMQ 服务应用，但是 Erlang 虚拟机还是处于运行状态。 |
| rabbitmqctl start_app            | 启动RabbitMQ 服务应用                                        |
| rabbitmqctl wait [pid_file]      | 等待 RabbitMQ 应用的启动。它会等到 pid_file 的创建，然后等待 pid_file 中所代表的进程启动。当指定的进程没有启动 RabbitMQ 应用而关闭时将会返回失败。 |
| rabbitmqctl reset                | RabbitMQ 节点重置还原到最初状态。包括从原来所在的集群中删除此节点，从管理数据库中删除所有的配置数据，如己配置的用户、 vhost 等，以及删除所有的持久化消息。执行rabbitmqctl reset 命令前必须停止RabbitMQ应用(比如先执行 rabbitmqctlstop_app) 。 |
| rabbitmqctl force_reset          | 强制将 RabbitMQ 节点重置还原到最初状态。不同于 rabbitmqctl reset 命令，rabbitmqctl force reset 命令不论当前管理数据库的状态和集群配置是什么，都会无条件地重置节点。它只能在数据库或集群配置己损坏的情况下使用。与 rabbitmqctl reset命令一样，执行 rabbitmqctl force reset 命令前必须先停止 RabbitMQ 应用。 |
| rabbitmqctl rotate_logs {suffix} | 指示 RabbitMQ 节点轮换日志文件。 RabbitMQ 节点会将原来的日志文件中的内容追加到"原始名称+后缀"的日志文件中，然后再将新的日志内容记录到新创建的日志中(与原日志文件同名)。当目标文件不存在时，会新创建。如果不指定后缀 suffix. 则日志文件只是重新打开而不会进行轮换。 |

#### 5.4.2 集群管理

| 命令                                             | 作用                                                         |
| ------------------------------------------------ | ------------------------------------------------------------ |
| rabbitmqctl join_cluster {cluster_node} [-- ram] | 将节点加入指定集群中。<br/>在这个命令执行前需要停止RabbitMQ应用并重置节点。 |
| rabbitmqctl cluster_status                       | 显示集群状态                                                 |
| rabbitmqctl change_cluster_node_type {disc\|ram} | 修改集群节点的类型。<br/>在这个命令执行前需要停止RabbitMQ应用。 |
| rabbitmqctl forget_cluster_node [--offine]       | 将节点重集群中删除，允许离线执行                             |
| rabbitmqctl update_cluster_nodes {clusternode}   | 在集群中的节点应用启动前咨询clusternode节点的最新信息，并更新相应的集群信息。 |
| rabbitmqctl force_boot                           | 确保节点可以启动，即使它不是最后一个关闭的节点。             |
| rabbitmqctl sync_queue [- p vhost] {queue}       | 指示未同步队列 queue 的 slave 镜像可以同步 master 镜像行的内容。同步期间此队列会被阻塞(所有此队列的生产消费者都会被阻塞)，直到同步完成。此条命令执行成功的前提是队列queue 配置了镜像。注意 ， 未同步队列中的消息被耗尽后 ， 最终也会变成同步，此命令主要用于未耗尽的队列。 |
| rabbitmqctl cancel_sync_queue [-p vhost] {queue} | 取消队列queue同步镜像的操作。                                |
| rabbitmqctl set_cluster_name {name}              | 设置集群名称。集群名称默认是集群中第一个节点的名称。         |

### 5.5 服务端状态

#### 1. 队列状态

**命令:  rabbitmqctl list_queues [-p vhost]\[queueinfoitem...]**

此命令返回队列的详细信息，如果无 [-p vhost] 参数，将显示默认的 vhost 为 " / " 中的队列详情 。 queueinfoitem 参数用于指示哪些队列的信息项会包含在结果集中，**结果集的列顺序将匹配参数的顺序** 。 queueinfoitem 可以是下面列表中的任何值 。

- **name**: 队列名称 。
- **durable**: 队列是否持久化 。
- **auto_delete**: 队列是否自动删除 。
- **arguments** : 队列的参数。
- **policy** : 应用到队列上的策略名称 。
- **pid**: 队列关联的 Erlang 进程的 ID 。
- **owner_pid**: 处理排他队列连接的 Erlang 进程 D 。 如果此队列是非排他的，此值将为空。
- **exclusive**: 队列是否是排他的 。
- **exclusive_consumer_pid**: 订阅到此排他队列的消费者相关的信道关联的 Erlang进程ID。如果此队列是非排他的，此值将为空 。
- **exclusive_consumer_tag** : 订阅到此排他队列的消费者的 consumerTag 。 如果此队列是非排他的，此值将为空。
- **messages_ready**: 准备发送给客户端的消息个数 。
- **messages_unacknowledged**: 发送给客户端但尚未应答的消息个数 。
- **messages**: 准备发送给客户端和未应答消息的总和 。
- **messages_ready_ram**: 驻留在内存中 messages_ready 的消息个数 。
- **messages_unacknowledged_ram**: 驻留在内存中 messages_unacknowledged的消息个数 。
- **messages_ram** : 驻留在内存中的消息总数 。
- **messages_persistent** : 队列中持久化消息的个数 。 对于非持久化队列来说总是 0 。
- **messages_bytes**: 队列中所有消息的大小总和 。 这里不包括消息属性或者任何其他开销。
- **messages_bytes_ready**: 准备发送给客户端的消息的大小总和。
- **messages_bytes_unacknowledged**: 发送给客户端但尚未应答的消息的大小总和。
- **messages_bytes_ram**: 驻留在内存中的 messages_bytes 。
- **messages_bytes_persistent**: 队列中持久化的 messages_bytes 。
- **disk_reads**: 从队列启动开始，己从磁盘中读取该队列的消息总次数。
- **disk_writes**: 从队列启动开始，己向磁盘队列写消息的总次数。
- **consumer**: 消费者数目。
- **consumer_utilisation**: 队列中的消息能够立刻投递给消费者的比率，介于 0 和1之间 。这个受网络拥塞或者 Basic.Qos 的影响而小于 1 。
- **memory**: 与队列相关的 Erlang 进程所消耗的内存字节数，包括栈、堆及内部结构 。
- **slave_pids**: 如果队列是镜像的 ，列出所有 slave 镜像的 pid 。
- **synchronised_slave_pids**: 如果队列是镜像的，列出所有己经同步的 slave 镜像的 pid 。
- **state** : 队列状 态。正常情况下是running : 如果队列正常同步数据可能会有"{syncing, MsgCount}" 的状态;如果队列所在的节点掉线了，则队列显示状态为down (此时大多数的 queueinfoitems 也将不可用〉。

**如果没有指定 queueinfoitems ，那么此命令将显示队列的名称和消息的个数。**  



#### 2. 交换机状态

**命令：rabbitmqctl list_exchanges [-p vhost]\[exchangeinfoitem...]**

- **name**: 交换器的名称。
- **type**: 交换器的类型。
- **durable** : 设置是否持久化。 durable 设置为 true 表示持久化，反之是非持久化。持久化可以将交换器信息存盘 ，而在服务器重启的时候不会丢失相关信息。
- **auto_delete** : 设直是否自动删除。
- **internal** : 是否是内置的。
- **arguments** : 其他一些结构化参数，比如 alternate-exchange 。
- **policy** : 应用到交换器上的策略名称。 

**如果没有指定 exchangeinfoitem, 那么此命令将显示交换器的名称和类型。** 



#### 3. 绑定状态

**命令：rabbitmqctl list_bindings [-p vhost]\[bingdinfoitem...]**

- **source_name**: 绑定中消息来源的名称。
- source_kind: 绑定中消息来源的类别。
- **destination_name**: 绑定中消息目的地的名称。
- **destination_kind**: 绑定中消息目的地的种类。
- **routing_key**: 绑定的路由键。
- **arguments**: 绑定的参数。

**如果没有指定 bindinginfoitem，那么将显示所有的条目。** 



#### 4. TCP|IP 连接状态

**命令:  rabbitmqctl list_connections [-p vhost]\[connectioninfoitem...]**

- **pid**: 与连接相关的 Erlang 进程 ID 。
- **name**: 连接的名称。
- **port**: 服务器端口。
- **host**: 返回反向 DNS 获取的服务器主机名称，或者 IP 地址，或者未启用。
- **peer_port**: 服务器对端端口。当一个客户端与服务器连接时，这个客户端的端口就是 peer_port 。
- **peer_host**: 返回反向 DNS 获取的对端主机名称，或者IP地址，或者未启用。 
- **ssl**: 是否启用 SSL 。
- **ssl_protocol**: SSL 协议，如 tlsv1 。
- **ssl_key_exchange**: SSL 密钥交换算法，如 rsa 。
- **ssl_cipher**: SSL 加密算法，如 aes_256_cbc 。
- **ssl_hash**: SSL 哈希算法，如 sha。
- **peer_cert_subject**: 对端的 SSL 安全证书的主题，基于RFC4514 的形式。
- **peer_cert_issuer**: 对端 SSL 安全证书的发行者， 基于RFC4514 的形式 。
- **peer_cert_validity**: 对端 SSL 安全证书的有效期。
- **state**: 连接状态，包括 starting 、tuning 、opening、 running 、flow 、blokcing 、blocked 、closing 和closed这几种。
- **channels**: 该连接中的信道个数。
- **protocol**: 使用的 AMQP 协议的版本，当前是 {0，9 ， 1} 或者 {0， 8 ，0} 。注意，如果客户端请求的是 AMQP 0-9 的连接， RabbitMQ 也会将其视为 0-9-l 。
- **auth_mechanism**: 使用的 SASL 认证机制，如 PLAIN 、 AMQPLAIN 、 EXTERNAL 、RABBIT-CR-DEMO 等 。
- **user**: 与连接相关的用户名。
- **vhost**: 与连接相关的 vhost 的名称。
- **timeout**: 连接超时/协商的心跳间隔，单位为秒。
- **frame** max: 最大传输帧的大小，单位为 B 。
- **channel_max**: 此连接上信道的最大数量。如果值 0 ，则表示无上限，但客户端一般会将 0 转变为 65535 
- **client_properties**: 在建立连接期间由客户端发送的信息属性。
- **recv_oct**: 收到的字节数。
- **recv_cnt**: 收到的数据包个数。 
- **send_oct**: 发送的字节数。
- **end_cnt** : 发送的数据包个数。
- **send_pend**: 发送队列大小。
- **connected_at** : 连接建立的时间戳。 



#### 5. 信道状态

**命令:  rabbitmqctl list_channels [-p vhost]\[channelinfoitem...]**

- **pid**: 与连接相关的 Erlang 进程 ID 。
- **connection** : 信道所属连接的 Erlang 进程 ID 。
- **name** : 信道的名称。
- **number**: 信道的序号。
- **user**: 与信道相关的用户名称。
- **vhost** : 与信道相关的 vhost。
- **transactional**: 信道是否处于事务模式。
- **confirm** : 信道是否处于 publisher confirm 模式。
- **consumer_count** : 信道中的消费者的个数。
- **messages_unacknowledged**: 己投递但是还未被 ack 的消息个数。 
- **messages_uncommitted** : 己接收但是还未提交事务的消息个数 。
- **acks_uncommitted** : 己 ack 收到但是还未提交事务的消息个数 。
- **messages_unconfirmed** : 己发送但是还未确认的消息个数 。 如果信道不处于publisher confmn 模式下 ，则此值为 0 。
- **perfetch_count** : 新消费者的 Qos 个数限制 。 0 表示无上限 。
- **global_prefetch_count**: 整个信道的 Qos 个数限制 。 0 表示无上限 。 



#### 6.消费者状态

**命令:  rabbitmqctl list_consumers [-p vhost]**



#### 7.Brokder的状态

**命令:  rabbitmqctl status**

显示 Broker 的状态， 比如当前 Erlang 节点上运行的应用程序、 RabbitMQ/Erlang 的版本信息、 os 的名称 、内存及文件描述符等统计信息。 



#### 8.其他状态

**rabbitmqctl node_health_check**
对 RabbitMQ 节点进行健康检查 ， 确定应用是否正常运行。

**rabbitmqctl environment**
显示每个运行程序环境中每个变量的名称和值。

**rabbitmqctl report**
为所有服务器状态生成一个服务器状态报告，井将输出重定向到一个文件。相关示例如下 :

```shell
[root@nodel -]# rabbitmqctl report > report.txt
```

**rabbitmqctl eval {expr}**
执行任意 Erlang 表达式。相关示例如下(示例命令用于返回 rabbitmqctl 连接的节点名称) :

```shell
[root@nodel - ]# rabbitmqctl eval 'node().'
rabbit@nodel 
```




# RabbitMQ 客户端开发

<nav>
<a href="#一基本-API">一、基本 API</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-连接服务">1.1 连接服务</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-声明交换器">1.2 声明交换器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-声明队列">1.3 声明队列</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#14-建立绑定关系">1.4 建立绑定关系</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#15-发送消息">1.5 发送消息</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#16-消费消息">1.6 消费消息</a><br/>
<a href="#二生产者与消费者开发">二、生产者与消费者开发</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-项目依赖">2.1 项目依赖</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-生产者">2.2 生产者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-消费者">2.3 消费者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-消费端确认">2.4 消费端确认</a><br/>
</nav>

## 一、基本 API

### 1.1 连接服务

不论是进行生产者还是消费者的开发，第一步都必须要先连接到 RabbitMQ Broker ，然后创建信道 Channel，Channel 是后续一切操作的基础。代码如下：

```java
// 1.创建连接工厂
ConnectionFactory factory = new ConnectionFactory();
// 2.配置服务器地址和连接信息
factory.setHost("localhost");
factory.setUsername("guest");
factory.setPassword("guest");
factory.setVirtualHost("/");
// 3.获取连接
Connection connection = factory.newConnection();
// 4.创建信道
Channel channel = connection.createChannel();
```

在 ConnectionFactory 类的源码中定义了大部分的默认属性 (如下)，你可以按需进行更改：

```java
public static final String DEFAULT_USER = "guest";
public static final String DEFAULT_PASS = "guest";
public static final String DEFAULT_VHOST = "/";
public static final int    DEFAULT_CHANNEL_MAX = 2047;
public static final String DEFAULT_HOST = "localhost";
public static final int    DEFAULT_AMQP_OVER_SSL_PORT = 5671;
```

需要注意的是 RabbitMQ 采用类似 NIO (非阻塞式 IO) 的设计，通过 Channel 来复用 TCP 连接，因此可以基于一个 Connection 来创建多个 Channel 实例，但 Channel 实例不是线程安全的，所以不能在多个线程之间共享一个 Channel 实例，而应该为每个线程单独创建一个 Channel 实例。

### 1.2 声明交换器

交换器是消息路由分发的核心组件，获取到 Channel 后就可以基于其实例方法 exchangeDeclare 创建交换器。exchangeDeclare 具有很多重载实现，这里选取参数最全面的一个进行讲解：

```java
Exchange.DeclareOk exchangeDeclare(String exchange,
                                              String type,
                                              boolean durable,
                                              boolean autoDelete,
                                              boolean internal,
                                              Map<String, Object> arguments) throws IOException;
```



+ **exchange**： 交换器的名称。
+ **type**：交换器的类型。交换器的常用类型都定义在 `BuiltInExchangeType ` 枚举类中。
+ **durable**：是否进行持久化。持久化可以将交换器的信息存储到磁盘，在服务器重启后不会丢失相关的信息。
+ **autoDelete**：是否自动删除。自动删除的前提是至少有一个队列或者其他交换器与该交换器进行过绑定，之后所有与该交换器绑定的队列或其他交换器都解除绑定关系后，该交换器会被自动删除。通常设置为 false。
+ **internal**：是否内置，如果设置 为true，则表示是内置的交换器，客户端程序无法直接发送消息到这个交换器中，只能通过交换器路由到交换器的方式。
+ **arguments**：其余可选配置。

### 1.3 声明队列

创建队列同样是基于 Channel 的实例方法来实现，常用的方法为 queueDeclare，其方法定义和参数列表如下： 

```java
Queue.DeclareOk queueDeclare(String queue, 
                             boolean durable, 
                             boolean exclusive, 
                             boolean autoDelete,
                             Map<String, Object> arguments) throws IOException;
```

+ **queue**：队列的名称。
+ **durable**：是否进行持久化。持久化可以将队列的信息存储到磁盘，在服务器重启后不会丢失相关的信息。
+ **exclusive**：是否声明为排它。排它队列仅对首次声明它的连接可见，也就是说它对该连接中的所有信道可见，但对于其他连接并不可见，如果创建它的连接关闭了，那么它就会被自动删除，哪怕设置了持久化属性 durable 为 true。
+ **autoDelete**：设置是否自动删除。自动删除的前提是：至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开连接时，才会自动删除。 
+ **arguments**：其余可选配置。

### 1.4 建立绑定关系

交换器与队列的绑定关系同样是基于 Channel 的实例方法来建立的，其方法定义和参数列表如下： 

```java
Queue.BindOk queueBind(String queue, String exchange, String routingKey) throws IOException;
```

+ **queue**：队列的名称；
+ **exchange**：交换器的名称；
+ **routingKey**：用于建立绑定关系的路由键。

除了可以为交换器与队列建立绑定关系，还可以为交换器和交换器建立绑定关系，从而实现多级路由，其方法定义如下：

```java
Exchange.BindOk exchangeBind(String destination, String source, String routingKey) throws IOException;
```

### 1.5 发送消息

声明好交换器和队列后，就可以通过 Channel 的实例方法 basicPublish 来发送消息，basicPublish 方法具有多个重载实现，这里依旧选择参数最全的进行讲解：

```java
void basicPublish(String exchange, 
                  String routingKey, 
                  boolean mandatory, 
                  boolean immediate, 
                  BasicProperties props, byte[] body) throws IOException;
```

- **exchange** ：消息投递的目标交换器。
- **routingKey**：路由键。
- **props**：可选属性。所有可选属性配置可以参考官方文档：[publishers](https://www.rabbitmq.com/publishers.html)
- **body**：需要传递的消息内容。
- **mandatory**：交换器负责接收来自生产者的消息，并将将消息路由到一个或者多个队列中，如果路由不到，则返回给生产者或者直接丢弃，这取决于交换器的 mandatory 属性：
  + mandatory = true ：如果交换器无法根据自身类型和路由键找到一个符合条件的队列，则将消息返回给生产者；
  - mandatory = false：如果交换器无法根据自身类型和路由键找到一个符合条件的队列，则直接丢弃该消息。
- **immediate** ：当 immediate 参数为 true 的情况下，如果消息路由到队列时，发现队列上不存在任何可用的消费者，那么这条消息将不会存入该队列，而是尝试路由到其他符合路由条件的队列上。当所有符合路由条件的队列都没有消费者时 ，该消息会通过 Basic.Return 返回至生产者。 

### 1.6 消费消息

RabbitMQ 的消费模式分两种 : 推 (Push) 模式和拉 (Pull) 模式：

#### 1.推模式

推模式采用 basicConsume 方法进行消费，basicConsume  将信道 (Channel) 设置为接收模式，直到订阅取消为止。在接收模式期间，RabbitMQ 会不断地推送消息给消费者。basicConsume  具有多个重载实现，这里选取其中参数较全的进行讲解：

```java
String basicConsume(String queue, boolean autoAck, 
                    String consumerTag, boolean noLocal, 
                    boolean exclusive, Map<String, Object> arguments, 
                    Consumer callback) throws IOException;
```

+ **queue**：待消费队列的名称。
+ **autoAck**：是否自动签收。
+ **consumerTag**：用于区分不同消费者的唯一标识。
+ **noLocal**：为 true 时表示不能将生产者的消息发送给同一个连接中的消费者。
+ **exclusive**：是否排它。设置这个值时，消费者需要在队列不存在其他消费者的情况下，申请成为这个队列的唯一消费者，从而确保在同一时间内只有一个消费者来消费队列中的消息。
+ **arguments**：其他可选配置。
+ **callback**：设置消费者的回调函数，用于处理获取到的消息。

#### 2.拉模式

如果只想从队列获得单条消息而不是持续订阅，可以采用拉模式。它采用 basicGet 方法进行消费，其 API 如下：

```java
GetResponse basicGet(String queue, boolean autoAck) throws IOException;
```

需要注意的是因为 basicGet 在实际执行时是先去订阅队列，然后获取第一条消息，最后再取消订阅。所以不能将 basicGet 放在一个循环里来代替 basicConsume，这会严重影响 RabbitMQ 的性能。大多数场景下，使用推模式就能满足使用需求。

## 二、生产者与消费者开发

下面给出一个完整的生产者和消费者的示例代码：

### 2.1 项目依赖

本项目采用 Maven 构建，需要导入 amqp-client 依赖，完整源码见本仓库：[rabbitmq-basis](https://github.com/heibaiying/Full-Stack-Notes/tree/master/code/RabbitMQ/rabbitmq-basis)

```xml
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>5.7.3</version>
</dependency>
```

### 2.2 生产者

```java
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2.配置服务器地址和连接信息
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        // 3.获取连接
        Connection connection = factory.newConnection();
        // 4.创建信道
        Channel channel = connection.createChannel();
        // 5.声明一个类型为 type 的持久化的、非自动删除的交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, null);
        // 6.指明路由键
        String routingKey = "my-key";
        // 7.需要传递的数据
        byte[] messageBodyBytes = "Hello RabbiMQ!".getBytes();
        // 8.将消息发布到指定的交换机上,设置投递模式为2,对应模式名为persistent,代表消息会被持久化存储
        channel.basicPublish(exchangeName, routingKey,
            new AMQP.BasicProperties.Builder().deliveryMode(2).build(),
            messageBodyBytes);
        // 9.关闭信道
        channel.close();
        // 10.关闭连接
        connection.close();
    }
}
```

### 2.3 消费者

```java
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2.配置服务器地址和连接信息
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        // 3.获取连接
        Connection connection = factory.newConnection();
        // 4.创建信道
        final Channel channel = connection.createChannel();
        // 5.声明一个类型为 type 的持久化的、非自动删除的交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, null);
        // 6.声明一个具名的、持久化的、非排他的、不自动删除的队列
        String queueName = "hello-queue";
        channel.queueDeclare(queueName, true, false, false, null);
        // 7.建立绑定关系
        String bindingKey = "my-key";
        channel.queueBind(queueName, exchangeName, bindingKey);
        // 8.订阅并消费消息
        channel.basicConsume(queueName, false, "myConsumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // 9.处理收到的消息
                System.out.println("Received：" + new String(body));
                // 10.手动ACK
                long deliveryTag = envelope.getDeliveryTag();
                channel.basicAck(deliveryTag, false);
            }
        });

        // 11.这里为了观察结果，先不关闭连接
        // channel.close();
        // connection.close();
    }
}
```

在以上示例代码中生产者和消费者都声明了 `hello-exchange` 交换器，是为了避免只有一方声明而另一方却先启动时出现找不到交换器的情况。同时你也不必担心两次声明会导致重复创建，RabbitMQ 会保证同一 Virtual Host 下不会出现两个完全相同的交换器或队列。

### 2.4 消费端确认

在示例代码中，basicConsume 方法关闭了自动确认模式，并使用 basicAck 进行手动的成功确认。basicAck 的定义如下：

```java
void basicAck(long deliveryTag, boolean multiple) throws IOException;
```

deliveryTag 为消息的唯一编码，它是一个单调递增的长整数，由程序自动生成。第二个参数 multiple 代表是否批量签收，如果设置为 true，则会一次签收所有 deliveryTag 小于等于当前 deliveryTag 的消息。basicAck 属于成功确认，除此之外你还可以使用 basicReject 进行拒绝确认，其方法声明如下：

```java
void basicReject(long deliveryTag, boolean requeue) throws IOException;
```

这里的第二个参数 requeue 代表是否重回队列，如果设置为 true，则会重新回到队列当中，此时就有可能再次分配给订阅该队列的其他消费者。basicReject 只能一次拒绝一条，如果想要拒绝多条，则可以使用 basicNack：

```java
void basicNack(long deliveryTag, boolean multiple, boolean requeue) throws IOException;
```



## 参考资料

1. 朱忠华 . RabbitMQ实战指南 . 电子工业出版社 . 2017-11-1
2. 官方文档：[Documentation: Table of Contents](https://www.rabbitmq.com/documentation.html)


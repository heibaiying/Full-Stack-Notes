package com.heibaiying;

import com.rabbitmq.client.*;

/**
 * 生产者
 */
public class Producer {

    private static final String EXCHANGE_NAME = "exchange-hello";
    private static final String ROUTING_KEY = "routingkey-hello";
    private static final String QUEUE_NAME = "queue-hello";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String IP_ADDRESS = "192.168.200.229";
    /* RabbitMQ 服务默认的连接端口号 */
    private static final int PORT = 5672;


    public static void main(String[] args) throws Exception {
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
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true, false, null);
        // 创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 将交换器与队列通过路由键绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String message = "hello world";
        // 发送一条持久化的文本消息
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        // 关闭信道
        channel.close();
        // 关闭连接
        connection.close();
    }
}

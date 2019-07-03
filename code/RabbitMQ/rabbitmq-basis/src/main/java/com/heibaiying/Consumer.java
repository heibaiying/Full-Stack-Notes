package com.heibaiying;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 消费者
 */
public class Consumer {

    private static final String QUEUE_NAME = "queue-hello";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String IP_ADDRESS = "192.168.200.229";
    /* RabbitMQ 服务默认的连接端口号 */
    private static final int PORT = 5672;

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        // 设置客户端最多接收多少个未被 Ack 的消息, 0 代表没有限制
        channel.basicQos(64);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("收到消息:" + new String(body));
                // 消息 Ack
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        // 等到回调函数执行后再关闭连接
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();

    }
}

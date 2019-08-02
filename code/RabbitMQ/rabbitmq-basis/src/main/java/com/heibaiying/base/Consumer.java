package com.heibaiying.base;

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

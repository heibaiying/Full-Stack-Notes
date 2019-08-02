package com.heibaiying.base;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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
		// 8.将消息发布到指定的交换机上
		channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
		// 9.关闭信道
		channel.close();
		// 10.关闭连接
		connection.close();
	}
}

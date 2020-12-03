package com.hobo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Hobo
 * @create 2020-12-03 10:01
 */
//RabbitMQ生产商流程
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //给连接工厂连接信息
        connectionFactory.setHost("192.168.136.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建信道
        Channel channel = connection.createChannel();

        //创建队列
        channel.queueDeclare("fanfan", true, false, false, null);

        //创建发送的消息
        String message = "略略略";

        //发送消息
        channel.basicPublish("", "fanfan", null, message.getBytes());
        System.out.println(message);
        //关闭连接
        channel.close();
        connection.close();
    }
}

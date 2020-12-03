package com.atguigu.rabbitmq.practice;

import com.atguigu.rabbitmq.simple.Producer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Hobo
 * @create 2020-12-02 20:58
 */

public class Sc {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPort(Producer.mq.getPort());
        connectionFactory.setHost(Producer.mq.getHost());
        connectionFactory.setVirtualHost(Producer.mq.getVirtualHost());
        connectionFactory.setUsername(Producer.mq.getUserName());
        connectionFactory.setPassword(Producer.mq.getPassWord());
        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare("hobo", true, false, false, null);

        //发送的消息
        String hobo = "这是hobo想要发送的信息";

        //发送消息动作
        channel.basicPublish("", "hobo", null, hobo.getBytes());
        System.out.println("成功发送消息：" + hobo);

        //关闭连接
        channel.close();
        connection.close();
    }
}

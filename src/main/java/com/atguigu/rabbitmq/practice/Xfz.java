package com.atguigu.rabbitmq.practice;


import com.atguigu.rabbitmq.simple.Producer;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Hobo
 * @create 2020-12-02 21:13
 */

public class Xfz {
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

        //创建消费者 接收消息
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };

        //创建监听器 监听消息有无
        String hobo = channel.basicConsume("hobo", true, consumer);
        System.out.println();


    }
}

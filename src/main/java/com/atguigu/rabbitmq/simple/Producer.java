package com.atguigu.rabbitmq.simple;

import com.atguigu.rabbitmq.simple.tool.MqTool;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Hobo
 * @create 2020-12-02 19:38
 */

public class Producer {

 public static   MqTool mq = new MqTool("192.168.136.128", 5672, "/", "admin", "admin");

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
            //设置主机地址
            connectionFactory.setHost(mq.getHost());
            //设置连接端口
            connectionFactory.setPort(mq.getPort());
            //设置想要连接虚拟主机名称
            connectionFactory.setVirtualHost(mq.getVirtualHost());
            //连接用户名
            connectionFactory.setUsername(mq.getUserName());
            //连接用户名密码
            connectionFactory.setPassword(mq.getPassWord());

        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //创建队列
        /**
         * queue      参数1：队列名称
         * durable    参数2：是否定义持久化队列,当mq重启之后,还在
         * exclusive  参数3：是否独占本次连接
         *            ① 是否独占,只能有一个消费者监听这个队列
         *            ② 当connection关闭时,是否删除队列
         * autoDelete 参数4：是否在不使用的时候自动删除队列,当没有consumer时,自动删除
         * arguments  参数5：队列其它参数
         */
        channel.queueDeclare("simple_queue", true, false, false, null);
        //创建消息
        String message = "你好 Rabbit";
        //发送消息
        /**
         * 参数1：交换机名称,如果没有指定则使用默认Default Exchange
         * 参数2：路由key,简单模式可以传递队列名称
         * 参数3：配置信息
         * 参数4：消息内容
         */
        channel.basicPublish("", "simple_queue", null, message.getBytes());
        System.out.println("已成功发送的消息为：" + message);
        //关闭信道 连接
        channel.close();
        connection.close();


    }
}

package com.atguigu.rabbitmq.simple.tool;

/**
 * @author Hobo
 * @create 2020-12-02 19:47
 */

public class MqTool {
    private String host;
    private Integer port;
    private String virtualHost;
    private String userName;
    private String passWord;

    public MqTool(String host, Integer port, String virtualHost, String userName, String passWord) {
        this.host = host;
        this.port = port;
        this.virtualHost = virtualHost;
        this.userName = userName;
        this.passWord = passWord;
    }

    public MqTool() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "MqTool{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", virtualHost='" + virtualHost + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

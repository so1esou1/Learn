package com.csu;

import redis.clients.jedis.Jedis;

//能够ping成功说明连接上了redis数据库
public class TestPing {
    public static void main(String[] args) {
        //1、new jedis对象即可
        Jedis jedis = new Jedis("192.168.0.108",6379);              //主机+端口号
        //2、jedis所以的方法就是我们之前学习的所有指令
        System.out.println(jedis.ping());
    }
}

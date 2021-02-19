package com.csu;

import redis.clients.jedis.Jedis;

public class TestKey01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.108",6379);
        System.out.println("清空数据:" + jedis.flushDB());
        System.out.println("判断某个键是否存在:" + jedis.exists("username"));
        System.out.println("新增<'password','kuangshen'>的键值对:" + jedis.set("username","csu"));
        System.out.println("删除键username:" + jedis.del("username"));

    }
}

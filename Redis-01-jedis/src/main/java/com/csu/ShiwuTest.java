package com.csu;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class ShiwuTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.108",6379);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","csu");

        Transaction multi = jedis.multi();              //开启事务
        String result = jsonObject.toJSONString();

        try {
            multi.set("user1",result);                      //执行命令
            multi.exec();                       //执行事务
        }catch (Exception e){
            multi.discard();        //放弃事务
        }finally {
            System.out.println(jedis.get("user1"));
            jedis.close();         //关闭连接
        }

    }
}

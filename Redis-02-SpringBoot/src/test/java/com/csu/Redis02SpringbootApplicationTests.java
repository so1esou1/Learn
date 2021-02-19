package com.csu;

import com.csu.pojo.User;
import com.csu.utils.RedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate; //注入redisTemplate这个bean

    @Autowired
    private RedisUtils redisUtils;     //注入redis的工具类

    @Test
    void contextLoads() {

        //redisTemplate，操作不同的数据类型，API和我们的指令是一样的
        //opsForValue() 操作字符串的，类似String
        //opsForList、opsForHash、opsForGeo等，与jedis无区别
        //在企业开发中大部分情况下都不会使用这个原生的方式去编写代码，可以写一个redisUtils工具类来操作

        redisTemplate.opsForValue().set("mykey","csu");            //尽量不使用中文，会被转义
        System.out.println(redisTemplate.opsForValue().get("mykey"));;

        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的crud


        /*获取redis的连接对象(一般不用这种方法)
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();
         */
    }



    @Test
    public void test() throws JsonProcessingException {
        //真实的开发一般使用json来传递对象
        User user = new User("csu",3);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
        //会报错，没有序列化，所以说所以对象都需要先序列化
        //序列化后才能成功传输，企业中所以的pojo类一般都会序列化
    }


    //测试工具类
    @Test
    public void test1(){
        redisUtils.set("name","csu");
        System.out.println(redisUtils.get("name"));
    }


}

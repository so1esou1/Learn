package com.csu.controller;

import com.alibaba.fastjson.JSON;
import com.csu.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class UserController {
    @RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @ResponseBody    //不会走视图解析器，会直接返回一个字符串
    public String json1() throws IOException {
        
        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("lily",3,"男");
        String str = mapper.writeValueAsString(user);

        return user.toString();
    }


    //返回多个json对象
    @RequestMapping("/j2")
    public String json2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        User user1 = new User("lily",3,"男");
        User user2 = new User("lily",3,"男");
        User user3 = new User("lily",3,"男");
        User user4 = new User("lily",3,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);

        return str;
    }


    @RequestMapping("/j3")
    public String json3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //使用ObjectMapper 来格式化输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);   //关闭时间戳

        //自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(sdf);

        Date date = new Date();
        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/j4")    //FASTJSON使用示范
    public String json4() throws IOException{

        List<User> userList = new ArrayList<User>();
        User user1 = new User("lily",3,"男");
        User user2 = new User("lily",3,"男");
        User user3 = new User("lily",3,"男");
        User user4 = new User("lily",3,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String string = JSON.toJSONString(userList);
        return string;
    }
}

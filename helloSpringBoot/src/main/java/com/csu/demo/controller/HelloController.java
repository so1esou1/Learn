package com.csu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //返回字符串
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        //调用业务，接收前端的参数
        return "hello,world";
    }
}

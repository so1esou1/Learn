package com.csu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/t1")
    public String test(){
        System.out.println("test()执行了");
        return "ok";
        //return false;   将不执行，网页跳转无反应
        //return true;    会放行
    }
}

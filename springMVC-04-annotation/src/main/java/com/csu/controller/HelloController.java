package com.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller   //controller控制器的注解，自动被spring管理了,不需要再配bean
//@RestController   写这个的话不会匹配jsp页面，下面代码返回字符串
public class HelloController {
    @RequestMapping("/h1")    //用来处理请求地址映射，也就是在浏览器地址栏输入http://localhost:8080/springMVC_04_annotation_war_exploded/h1进入
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation!");
        return "hello";    //会被视图解析处理
    }

}

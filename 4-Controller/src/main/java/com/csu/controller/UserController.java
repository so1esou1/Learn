package com.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(String name, Model model){
        //1、接收前端参数
        System.out.println("接收到前端的参数为:" + name);
        //2、将返回的结果传递给前端,使用Model
        model.addAttribute("msg",name);

        //3、跳转视图
        return "test";

    }
}

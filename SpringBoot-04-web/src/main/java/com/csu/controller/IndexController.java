package com.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在templates下的所有页面只能通过controller来跳转！
//这个需要模板引擎的支持 thymeleaf的依赖
@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h1>hellospringboot</h1>");

        model.addAttribute("users", Arrays.asList("girl","jing"));
        return "test";
    }
}

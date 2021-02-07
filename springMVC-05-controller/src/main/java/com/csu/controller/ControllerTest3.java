package com.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")        //RequestMapping注解可以加到类，也可以加到方法上，会影响映射的地址
public class ControllerTest3 {

    @RequestMapping("/t1")     //要在地址栏输入  c3/t1  才能访问这个方法
    public String test1(Model model){
        model.addAttribute("msg","ControllerTest3");
        return "test";
    }
}

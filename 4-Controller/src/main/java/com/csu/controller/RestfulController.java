package com.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestfulController {
    //原来的方式:http://localhost:8080/springMVC_04_annotation/add?a=1&b=1
    /*@RequestMapping("/add")
    public String test1(int a, int b, Model model){
        int res = a + b;
        model.addAttribute("msg","结果为" + res);
        return "test";
    }*/

    //restful风格:
    @RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){       //路径变量,让参数的值可以直接绑定到URI模板变量上
        int res = a + b;
        model.addAttribute("msg","结果为" + res);
        return "test";
    }

}

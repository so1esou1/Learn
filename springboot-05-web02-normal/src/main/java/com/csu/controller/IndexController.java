package com.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /*@RequestMapping({"/","/index.html"})            //这两种方式都可以转过去，因此弄成一个数组.不建议这样做，建议直接在config类中扩展MVC
    public String index(){
        return "index";
    }*/

}

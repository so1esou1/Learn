package com.csu.controller;
/*
使用springMVC来实现转发和重定向-无须视图解析器
  测试前将视图解析器注释掉
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MdelTest1 {

    /*@RequestMapping("/m1/t1")
    public String test(Model model){
        return "test";  //有视图解析器直接写就行了
    }*/

    @RequestMapping("/m1/t1")
    public String test2(Model model){
        //转发
        model.addAttribute("msg","ModelTest1");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t1")
    public String test3(Model model){
        //重定向
        model.addAttribute("msg","ModelTest1");
        return "redirect:/index.jsp";
    }

}

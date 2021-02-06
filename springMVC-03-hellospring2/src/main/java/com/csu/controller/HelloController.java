package com.csu.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //业务代码
        String result = "HelloSpringMVC";        //暂时用简单的业务

        mv.addObject("msg",result);        //封装

        //视图跳转
        mv.setViewName("test");      //设置视图的名字

        return mv;
    }
}

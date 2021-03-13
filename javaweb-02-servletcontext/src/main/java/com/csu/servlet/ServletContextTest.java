package com.csu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContextTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");

        //this.getInitParameter();      获得初始化的参数
        //this.getServletConfig()       Servlet配置
        //this.getServletContext()      Servlet上下文
        ServletContext context = this.getServletContext();
        String username = "张三";
        context.setAttribute("username",username);          //设置值,键值对的方式key-value
    }
}

package com.csu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //context-param已在web.xml中配置好

        //ServletContext的四个常见作用：
        //    a、获取web.xml配置的上下文参数
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("context-param参数username的值是：" + username);//context-param参数username的值是：context
        System.out.println("context-param参数password的值是：" + context.getInitParameter("password"));//context-param参数password的值是：root
        //    b、获取当前的工程路径
        System.out.println("当前工程路径：" + context.getContextPath());

        //    c、获取工程部署后在服务器磁盘上的绝对路径
        //    "/"被服务器解析地址为http://ip:port/工程名/   映射到IDEA代码的web目录<br/>
        System.out.println("工程部署的路径是:" + context.getRealPath("/"));
        //同理可以获取web下其他文件的路径：
        System.out.println("工程下imgs目录的绝对路径是:" + context.getRealPath("/imgs"));

        //    d、像Map一样存取数据
        //    见ContextServlet1
    }
}

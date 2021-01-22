package com.csu.servlet;
//ServletContext是在web工程部署启动的时候创建，在web工程停止的时候销毁。
//在重启之前，可以获得ContextServlet1中的context的值，重启之后就销毁了
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("context2中获取域数据key1的值是:" + context.getAttribute("key1"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

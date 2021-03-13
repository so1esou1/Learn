package com.csu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    从这个servlet中获取context的值
 */
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先需要获取ServletContext对象
        //注意:每个工程中只有一个ServletContext对象，不同类中都是在操作同一个ServletContext
        ServletContext context = this.getServletContext();
        String username = (String)context.getAttribute("username"); //程序不知道是什么类型，需要从Object强转成String

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("名字" + username);
        //需要先访问hello页面，再跳转到get页面才有值
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

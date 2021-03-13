package com.csu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        System.out.println("进入了Demo4");
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp");//请求转发,转发地址是gp页面
        requestDispatcher.forward(req,resp);    //传入这两个参数，最终实现请求的转发

        //注意:最后将显示demo3的页面，但是地址栏还是demo4的，路径不会变。重定向路径会发生改变!!!
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.csu.servlet;

import com.csu.pojo.Preson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Permission;

/*
    取出SessionTest2中的session
 */
public class SessionTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type","text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //得到Session
        HttpSession session = req.getSession();

        //显示出session中的preson对象:
        Preson preson = (Preson) session.getAttribute("name");
        System.out.println(preson.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.csu.servlet;
/*
    创建一个cookie顶替掉demo1中的cookie，设置有效时间为0，这样的话就相当于删除了一个cookie!!!
 */
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建的cookie必须跟上一个cookie的名字一致
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");

        //设置有效期:
        cookie.setMaxAge(0);

        //添加cookie
        resp.addCookie(cookie);

        //之后访问cookie2就会清掉cookie
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

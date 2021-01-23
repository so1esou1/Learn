package com.csu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReceiveCookieToServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request对象中获取所有提交的Cookie
        Cookie[] cookies = request.getCookies();
        //判断
        if(cookies != null){
            for(Cookie cookie : cookies){
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                System.out.println(cookieName + "=" + cookieValue);
            }
        }
    }
}

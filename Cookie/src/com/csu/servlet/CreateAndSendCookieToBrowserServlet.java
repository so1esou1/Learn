package com.csu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAndSendCookieToBrowserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建cookie对象
        Cookie cookie1 = new Cookie("username","zhangsan");     //参数是name和value
        Cookie cookie2 = new Cookie("password","123");

        //设置cookie的关联路径
        cookie1.setPath(req.getContextPath() + "/king");
        cookie2.setPath(req.getContextPath() + "/king");

        //设置cookie有效时长
        //cookie有效时长=0，会被直接删除，<0不会被存储，必须>0
        //以秒计数
        cookie1.setMaxAge(60 * 60);
        cookie2.setMaxAge(60 * 60 * 24);


        //将cookie对象发送给浏览器客户端
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        //浏览器将其保存在缓存中
    }
}

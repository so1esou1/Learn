package com.csu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/*
    保持用户上一次访问的时间:
 */
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器告诉你,你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了
        resp.setHeader("content-type","text/html;charset=UTF-8");   //乱码加上
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        //cookie,服务器端从客户端获取:
        Cookie[] cookies = req.getCookies();        //这里返回数组，说明cookie可能存在多个

        //判断cookie是否存在:
        if (cookies != null){
            //如果存在，怎么办?
            //取出想要的信息:
            out.write("您上一次访问的时间是:");
            for (int i = 0;i < cookies.length;i ++){
                Cookie cookie = cookies[i];
                //获取cookie的名字:
                if (cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值:
                    String value = cookie.getValue();//拿到的是一个时间的字符串，讲字符串解析成long类型:
                    long lastLoginTime = Long.parseLong(value);
                    //讲lastLoginTime转换成一个日期对象:
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());       //转换成本地日期的格式
                }
            }
        }else {
            out.write("这是您第一次访问本网站");
        }

        //服务器给客户端响应一个cookie:
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");     //可以在开发者工具的application中查看cookie
        cookie.setMaxAge(24*60*60);     //给cookie设置有效期为一天

        resp.addCookie(cookie);     //添加cookie


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

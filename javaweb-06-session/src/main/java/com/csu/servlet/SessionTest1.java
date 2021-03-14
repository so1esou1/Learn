package com.csu.servlet;

import com.csu.pojo.Preson;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setHeader("content-type","text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //得到Session
        HttpSession session = req.getSession();

        //给Session中存东西
        session.setAttribute("name",new Preson("张三",20));

        //获取Session的id
        String id = session.getId();

        //判断是不是新的Session
        if (session.isNew()){
            resp.getWriter().write("session创建成功,ID:" + id);
        }else {
            resp.getWriter().write("session已经在服务器中存在了,ID:" + id);
        }
        //浏览器显示:session已经在服务器中存在了,ID:36D3E33CCA235798FF1C87C6A4DDDA20


        //session创建时做了什么事情:
        //创建了一个JSESSIONID的cookie
        Cookie cookie = new Cookie("JSESSIONID", id);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

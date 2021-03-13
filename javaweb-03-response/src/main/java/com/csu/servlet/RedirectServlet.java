package com.csu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        重定向的原理,实现了以下这两步:
        resp.setHeader("Location","/r/img");
        resp.setStatus(302);    302编号代表SC_MOVED_TEMPORARILY移动
         */
        resp.sendRedirect("/javaweb_03_response/image");        //转到image页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

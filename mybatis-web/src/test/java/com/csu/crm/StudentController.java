package com.csu.crm;

import com.csu.domain.Student;
import com.csu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/student/save.do"})  //加webservlet的注解,发送/student/save.do请求之后就会执行这里的方法
//同理过滤器、监听器注解:
/*
@WebFilter
@WebListener
 */
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/student/save.do".equals(servletPath)){
            doSave(request,response);
        }
    }

    //写一个dosave方法
    protected void doSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收参数
        String id = UUIDGenerrator.generate();
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        Student s = new Student();
        //封装数据
        s.setId(id);
        s.setName(name);
        s.setBirth(birth);
        //调用service代理
        StudentService studentService =
                (StudentService)new TransactionHandler(new StudentServiceImpl()).getProxy();
        boolean ok = studentService.save(s);
        //响应json
        response.getWriter().print("{\"success\" : " + ok + "}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}

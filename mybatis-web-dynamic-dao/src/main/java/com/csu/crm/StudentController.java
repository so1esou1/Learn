package com.csu.crm;

import com.csu.domain.Student;
import com.csu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/student/save.do","/student/save2.do"})  //为了演示多个参数传递，这里加上一个路径
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/student/save.do".equals(servletPath)){
            doSave(request,response);
        }else if("/student/save2.do".equals(servletPath)){    //有两种参数可以传递
            doSave2(request,response);
        }
    }
    //写一个save2方法
    protected void doSave2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收参数
        String id = UUIDGenerrator.generate();
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        //与save方法不同，save2不封装数据
        //调用service
        StudentService studentService =
                (StudentService)new TransactionHandler(new StudentServiceImpl()).getProxy();
        boolean ok = studentService.save2(id,name,birth);
        response.getWriter().print("{\"success\" : " + ok + "}");

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

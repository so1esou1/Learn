package com.csu.crm;

import com.csu.domain.Student;
import com.csu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/student/save.do","/student/del.do","/student/saves.do"})  //加webservlet的注解,发送/student/save.do请求之后就会执行这里的方法
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
        }else if ("/student/del.do".equals(servletPath)){
            doDel(request,response);
        }else if("/student/saves.do".equals(servletPath))
            doSaves(request,response);
    }

    protected void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");
        StudentService studentService =
                (StudentService)new TransactionHandler(new StudentServiceImpl()).getProxy();
        boolean ok = studentService.deleteByIds(ids);
        response.getWriter().print("{\"success\" : " + ok + "}");
    }


    protected void doSaves(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //模拟数据1
        Student s1 = new Student();
        s1.setId(UUIDGenerrator.generate());
        s1.setName("jack");
        s1.setBirth("2000-10-10");
        //模拟数据2
        Student s2 = new Student();
        s2.setId(UUIDGenerrator.generate());
        s2.setName("lucy");
        s2.setBirth("2000-10-10");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl().getProxy());
        boolean ok = studentService.saves(studentList);
        response.getWriter().print("{\"success\" : " + ok + "}");
    }


    //写一个dosave方法
    protected void doSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收参数
        String id = UUIDGenerrator.generate();
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        //封装数据
        Student s = new Student();
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

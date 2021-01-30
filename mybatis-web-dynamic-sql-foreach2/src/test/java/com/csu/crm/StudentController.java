package com.csu.crm;

import com.csu.domain.Student;
import com.csu.service.impl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/student/save.do","/student/del.do","/student/saves.do","/student/page.do"})  //加webservlet的注解,发送/student/save.do请求之后就会执行这里的方法
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
        }else if("/student/saves.do".equals(servletPath)){
            doSaves(request,response);
        }else if ("/student/page.do".equals(servletPath))
            doPage(request,response);
    }


    protected void doPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取前端浏览器提交过来的数据
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");

        //将以上的查询条件传送给service
        Map<String,Object> conditionMap = new HashMap<>();
        conditionMap.put("startIndex",(pageNo - 1)* pageSize);   //mybatis中不支持加减乘除运算，所以在这里提前算好
        conditionMap.put("pageSize1",pageSize);
        conditionMap.put("name1",name);
        conditionMap.put("birth1",birth);

        //调用service
        StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
        Map<String,Object> pageMap = studentService.getPageByCondition(conditionMap);
        //将以上的对象转换成json格式的字符串，响应到浏览器
        //java对象转换成json格式的字符串，可以借助jackson插件来完成，没必要拼接字符串
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(pageMap);
        response.getWriter().println(json);
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

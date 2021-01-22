package com.csu.servlet;
//ServletConfig类的使用
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet4 implements Servlet {
    public HelloServlet4() {
        System.out.println("1 构造器方法");
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

        //servletconfig三大作用：
        //    1、可以获取servlet程序的别名servlet-name值
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());    //HelloServlet程序的别名是：HelloServlet4
        //    2、可以初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));   //括号内写参数名，在web.xml中已定义   //初始化参数username的值是：root
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));    //初始化参数url的值是：jdbc:mysql://localhost:3306/test
        //    3、获取ServletContent对象
        System.out.println(servletConfig.getServletContext());  //org.apache.catalina.core.ApplicationContextFacade@6ec2ed4f
    }



    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException{

        System.out.println("3 service === Hello World!");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String method = httpServletRequest.getMethod();

        if("GET".equals(method)){
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }

    }


    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }


    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }

    public void destroy(){
        System.out.println("4 destroy销毁方法");
    }
    public String getServletInfo(){
        return null;
    }
    public ServletConfig getServletConfig(){
        return null;
    }
}

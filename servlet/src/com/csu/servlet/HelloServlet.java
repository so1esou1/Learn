package com.csu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//这些要导入的包都在tomcat的lib文件夹中的servlet-api.jar中，解压就能看到，把servlet-api.jar地址配置到环境变量中
//这里配环境变量只起编译作用，与运行期无关，tomcat不需要配置
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    public void init(ServletConfig config) throws ServletException{
        System.out.println("2 init初始化方法");
    }

    /**
     *  service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws IOException
     * @throws ServletException
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException{
        //将信息打印输出到控制台【而不是输出到浏览器】
        System.out.println("3 service === Hello World!");

        //类型转换，因为有getMethod()方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //获取请求的方式
        String method = httpServletRequest.getMethod();

        if("GET".equals(method)){
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }
        //System.out.println("get请求");
        //System.out.println("post请求");
    }

    //把获取get、post请求写成一个方法

    /**
     * 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
     * 做post请求的操作
     */
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


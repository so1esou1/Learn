package com.csu.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;    //标准输出流，不需要关闭

public class WelcomeServlet {
    public class HelloServlet implements Servlet {

        public void init(ServletConfig config) throws ServletException {
        }

        public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException{
            //解决响应的时候中文乱码的问题
            //设置响应的内容类型以及字符编码方式
            response.setContentType("text/html;charset=UTF-8");


            //将信息输出到浏览器上
            //将HTML字符串输出到浏览器，浏览器解释执行
            //获取输出流对象，流直接指向特定的浏览器客户端
            PrintWriter out = response.getWriter();

            //这里设置字符编码方式就太晚了
            //response.setContentType("text/html;charset=UTF-8");

            //响应HTML代码到浏览器
            //html中使用println换行不好，加大体积
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<title>welcome servlet</title>");
            out.print("<body>");
            out.print("<h1 align=\"center\">welcome study servlet!</h1>");
            out.print("</html>");
        }
        public void destroy(){
        }
        public String getServletInfo(){
            return null;
        }
        public ServletConfig getServletConfig(){
            return null;
        }
    }
}

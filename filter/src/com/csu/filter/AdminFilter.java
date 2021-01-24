package com.csu.filter;
//filter过滤器初体验

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter(){
        System.out.println("1.fliter构造器方法AdminFilter()");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //filterconfig类
        System.out.println("2.filter的init(FilterConfig filterConfig)初始化方法");
        //1、获取filter的名称filter-name的内容
        System.out.println("filter-name的值是：" + filterConfig.getFilterName());
        //2、获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username的值是:" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是:" + filterConfig.getInitParameter("url"));
        //3、获取ServletContext对象
        System.out.println(filterConfig.getServletContext());

    }

    /**
     * doFilter方法，专门用于拦截请求、过滤响应
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter的doFilter()方法");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登录
        //不准进入
        if (user == null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else {
            //登录的情况，让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);

        }
    }

    @Override
    public void destroy() {
        System.out.println("4.filter的destroy()销毁方法");
    }
}

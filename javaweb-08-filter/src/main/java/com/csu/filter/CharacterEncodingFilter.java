package com.csu.filter;

import javax.servlet.*;
import java.io.IOException;

/*
    创建一个字符编码过滤器
    继承filter接口(有很多同名的filter，记得包不要导错了)
    重写三个方法
 */
public class CharacterEncodingFilter implements Filter {

    //初始化,web服务器启动就初始化了，随时等待过滤
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    //过滤器的主体
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");   //请求转换成utf-8
        servletResponse.setCharacterEncoding("utf-8");  //响应转换成utf-8
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter执行前。。。");

        //让请求继续走下去，如果不写程序到这里就会拦截停止了
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("CharacterEncodingFilter执行后。。。");
    }

    //销毁，关闭服务器时销毁
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}

package com.csu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取要下载的文件名
        String downloadFileName = "sword.jpg";
        //2、读取要下载的文件内容
        //通过ServletContext对象可以读取
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/image/" + downloadFileName);
        //System.out.println("下载的文件类型：" + mimeType);
        //4、回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5、告诉客户端收到的数据是用于下载的
        //Context-Disposition响应头表示收到的数据怎么处理
        resp.setHeader("Context-Disposition","attachment;filename" + downloadFileName);
        //attachment表示附件，表示下载使用；filename= 表示指定下载的文件名

        //解决谷歌和IE（使用的URL码）中文下载名乱码的问题：
        //resp.setHeader("Context-Disposition","attachment;filename" + URLEncoder.encode("中国.jpg","UTF-8"));

        InputStream resourceAsStream = servletContext.getResourceAsStream("/image/" + downloadFileName);
        OutputStream outputStream = resp.getOutputStream();        //commom.io包中的方法
        //3、把下载的文件内容回传给客户端
        //读取流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);



    }
}

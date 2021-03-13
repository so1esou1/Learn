package com.csu.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            下载文件的思路:
                1. 要获取下载文件的路径
                2. 下载的文件名是啥？
                3. 设置想办法让浏览器能够支持下载我们需要的东西
                4. 获取下载文件的输入流
                5. 创建缓冲区
                6. 获取OutputStream对象
                7. 将FileOutputStream流写入到buffer缓冲区
                8. 使用OutputStream将缓冲区中的数据输出到客户端！
         */

        //1、获取文件下载的路径:
        String path = "C:\\Users\\xfs\\IdeaProjects\\javawebkuang\\javaweb-03-response\\target\\classes\\1.jpg";
        System.out.println("下载文件的路径:" + path);
        //这里输出的下载文件的路径是:
        // C:\Users\xfs\IdeaProjects\javawebkuang\out\artifacts\javaweb_03_response_war_exploded\
        //需要更改文件路径，这里暂时只能写成绝对路径

        //2、下载的文件名是啥?
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        //3、***重难点:想办法设置让浏览器(Content-Disposition)能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));    //参数需要从网上查找
        //4. 获取下载文件的输入流
        FileInputStream fis = new FileInputStream(path);
        //5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6. 获取OutputStream对象
        ServletOutputStream os = resp.getOutputStream();
        //7. 将FileOutputStream流写入到buffer缓冲区,8. 使用OutputStream将缓冲区中的数据输出到客户端！
        while (fis.read(buffer) != -1){
            os.write(buffer,0,len);
        }

        //关闭流:
        fis.close();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

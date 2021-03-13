package com.csu.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*
    验证码功能
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器3秒自动刷新一次
        resp.setHeader("refresh","3");

        //如何在内存中创建一个图片(下面创建的是一个空的图片)
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片(能够在图片上进行修改)
        Graphics graphics = (Graphics2D) image.getGraphics();   //想象成拿到了一只笔
        //设置图片的背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);   //坐标和大小

        //给图片写数据(自己画)
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeRandom(),0,20);

        //***告诉浏览器这个请求用图片的方式打开
        resp.setContentType("image/jpeg");

        //网站有缓存，需要不让浏览器缓存:
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器:
        ImageIO.write(image,"jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    //写一个生成随机数的方法使用
    private String makeRandom(){
        Random random = new Random();
        //设置成随机数字符串
        String num = random.nextInt(99999999) + "";
        //字符串拼接
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < 7 - num.length();i ++){
            sb.append("0");
        }
        String s = sb.toString() + num;
        return num;
        //这样才能保证随机数一定是7位的
    }
}

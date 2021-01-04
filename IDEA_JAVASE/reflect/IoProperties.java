package com.bjpowernode.java.reflect;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

/*
从此之后，以前学IO流写的地址都得更改，不然无法应用到linux系统
 */
public class IoProperties {
    public static void main(String[] args) throws Exception{
        //获取一个文件的绝对路径了！！！
        //String path = Thread.currentThread().getContextClassLoader().getResource("classinfo2.properties").getPath();

        //更先进的方式：直接以流的方式返回：
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("classinfo2.properties");

        //FileReader reader = new FileReader();
        Properties pro = new Properties();
        pro.load(reader);
        reader.close();
        //通过key获取value
        String className = pro.getProperty("className");
        System.out.println(className);

    }
}

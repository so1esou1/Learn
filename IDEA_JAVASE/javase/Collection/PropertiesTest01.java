package com.bjpowernode.javase.Collection;

import java.util.Properties;

/*
目前只需要掌握Properties属性类对象的相关方法即可
Properties是一个Map集合，继承Hashtable，Properties的key和value都是String类型
Properties被称为属性类对象
Properties是线程安全的
 */
public class PropertiesTest01 {
    public static void main(String[] args) {
        //创建一个Properties对象
        Properties pro = new Properties();
        //需要掌握Properties的两个方法，一个存，一个取
        pro.setProperty("username","root");
        pro.setProperty("password","123");
        pro.setProperty("url","xxxxxxxx");
        pro.setProperty("driver","yyyyyyy");

        //通过key获取value
       String username = pro.getProperty("username");
       String password = pro.getProperty("password");
       String url = pro.getProperty("url");
       String driver = pro.getProperty("driver");

        System.out.println(username);
        System.out.println(password);
        System.out.println(url);
        System.out.println(driver);//获取到了value值
    }
}

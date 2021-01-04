package com.bjpowernode.java.reflect;

import java.util.ResourceBundle;

/*
java.util包下提供的资源绑定器，便于获取属性配置文件中的内容
使用以下这种方式的时候属性配置文件xxx.properties必须放到类路径下
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        //资源绑定器，只能绑定xxx.properties，且必须在类路径下，写路径时后面的扩展名不能写.properties。要求苛刻
        ResourceBundle bundle = ResourceBundle.getBundle("classinfo2");

        String className = bundle.getString("className");
        System.out.println(className);

    }
}

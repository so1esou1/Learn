package com.bjpowernode.java.reflect;

import com.bjpowernode.java.service.UserService;

import java.lang.reflect.Method;

/*
通过反射机制调用对象的方法（要求重点掌握）*****

反射机制让代码很具有通用性，可变化的内容都是写到配置文件中
将来修改配置文件之后，创建的对象不一样了，调用的方法也不同了
但是java代码不需要做任何改动，这就是反射机制的魅力
 */
public class ReflectTest10 {
    public static void main(String[] args) throws Exception {
        //不使用反射机制怎么调方法
        UserService userService = new UserService();
        boolean loginSuccess = userService.login("admin","123");
        System.out.println(loginSuccess);
        //要素分析：1、对象UserService 2、login方法 3、实参列表 4、返回值   四要素

        //使用反射机制调用方法
        Class userServiceClass = Class.forName("com.bjpowernode.java.service.UserService");
        //创建对象
        Object obj = userServiceClass.newInstance();
        //获取Method(不能通过名字获取方法，因为可能overload重载)
        Method loginMethod = userServiceClass.getDeclaredMethod("login",String.class,String.class);
        //调用方法
        //调用方法有几个要素？4个
        //****反射机制中最重要的一个方法，必须死记
        Object retValue = loginMethod.invoke(obj,"admin","123");
        //LoginMethod方法、obj对象、实参、返回值retValue
    }
}

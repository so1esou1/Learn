package com.bjpowernode.java.reflect;
/*
重点：怎么获取一个类的父类,以及实现了哪些接口？
 */
public class ReflectTest13 {
    public static void main(String[] args) throws Exception{

        //String举例
        Class stringClass = Class.forName("java.lang.String");

        //获取String的父类
        Class superClass = stringClass.getSuperclass();
        System.out.println(superClass.getName());   //java.lang.Object

        //获取String类实现的所有接口（一个类可以实现多个接口）
        Class[] interfaces = stringClass.getInterfaces();
        for (Class in : interfaces){
            System.out.println(in.getName());
        }
    }
}

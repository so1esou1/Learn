package com.bjpowernode.java.reflect;

import java.util.Date;

/*
反射机制：
    要操作一个类的字节码，需要首先获取这个类的字节码，怎么获取java.lang.Class实例？
        三种方式：
            第一种方式：Class c = Class.forName("完整类带包名");
            第二种方式：Class c = 对象.getClass();
            第三种：Class c = 任何类型.class
 */
public class ReflectTest01 {
    public static void main(String[] args) {
        /*
        Class.forName()：
            1、静态方法
            2、方法的参数是一个字符串
            3、字符串需要的是一个完整类名。
            4、完整类名必须带有包名,java.lang包也不能省略
         */
        Class c1 = null;
        Class c2 = null;
        try {
            //第一种方式：Class c = Class.forName("完整类带包名");
            c1 = Class.forName("java.lang.String");  //c1代表String.class文件，或者说c1代表String类型
            c2 = Class.forName("java.util.Date");  //c2代表Date类型
            Class c3 = Class.forName("java.lang.Integer");  //c3代表Integer类型
            Class c4 = Class.forName("java.lang.System");  //c4代表System类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //第二种方式：Class c = 对象.getClass();
        //java中任何一个对象都有一个方法getClass()
        String s = "abc";
        Class x = s.getClass();   //x代表String.class字节码文件，x代表String类型
        System.out.println(c1 == x);   //true，（==判断的是对象的内存地址，c1和x保存的内存地址是一样的。字节码文件装载到JVM中始终只有一份）

        Date time = new Date();
        Class y = time.getClass();
        System.out.println(c2 == y);  //true,c2和y两个变量中的内存地址都是一样的，都指向方法区中的字节码文件

        //第三种：java语言中任何一种类型，包括基本数据类型，都有.class属性
        Class z = String.class;  //z代表String类型
        Class k = Date.class;  //k代表Date类型
        Class f = int.class;  //f代表int类型
        Class e = double.class;  //e代表double类型
        System.out.println(x == z);  //true
    }
}

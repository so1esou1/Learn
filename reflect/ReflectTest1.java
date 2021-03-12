package com.bjpowernode.java2.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    反射机制概述:
    允许程序在执行期借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法

    类:
        java.lang.Class:代表一个类
        java.lang.reflect.Method:代表类的方法
        java.lang.reflect.Field:代表类的成员变量
        java.lang.reflect.Constructor:代表类的构造器


*/
public class ReflectTest1 {
    public static void main(String[] args) throws Exception, IllegalAccessException, InvocationTargetException, InstantiationException {
        //使用反射之前:
        Person p1 = new Person("wq",12);
        p1.name = "ee";
        p1.example();


        //使用反射之后:
        Class clazz = Person.class;     //创建Person的类
        Constructor cons = clazz.getConstructor(String.class, int.class);   //使用构造器方法
        Object obj =  cons.newInstance("QW", 12);       //创建Person的实例化对象
        Person p2 = (Person) obj;
        //通过反射调用对象指定的属性、方法:
        Field num = clazz.getDeclaredField("num");
        num.set(p2,10);
        //调用方法:
        Method ex = clazz.getDeclaredMethod("example");
        ex.invoke(p2);

        //通过反射可以调用Person类的私有的结构的:
        Constructor cons1 = clazz.getDeclaredConstructor(int.class);
        cons1.setAccessible(true);
        Person p3 = (Person) cons1.newInstance(12);
    }
}




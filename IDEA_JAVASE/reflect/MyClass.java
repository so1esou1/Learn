package com.bjpowernode.java.reflect;

public class MyClass{
    //静态代码块在类加载时执行，并且只执行一次
    static {
        System.out.println("MyClass类的静态代码块执行了！");
    }
}


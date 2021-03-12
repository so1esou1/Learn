package com.bjpowernode.java2.JDK8;
/*
    自定义一个函数式接口:
    lambda表达式本质上就是作为函数式表达式的实例
 */

import java.util.function.Consumer;

@FunctionalInterface        //写不写这个注解无所谓
public interface FunctionalInterfaceTest1 {
    void method();
}



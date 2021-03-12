package com.bjpowernode.java2.reflect;

import java.lang.annotation.ElementType;

/*
    哪些类型可以有Class对象？
        class(外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类)
        interface接口
        数组
        枚举
        注解
        基本数据类型
        void
 */
public class ReflectTest3 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);     //true
    }
}

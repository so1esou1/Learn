package com.bjpowernode.javase.integer;

public class IntegerTest04 {
    public static void main(String[] args) {
        //通过访问包装类的常量，来获取最大值和最小值
        System.out.println("int的最大值：" + Integer.MAX_VALUE);//int的最大值：2147483647
        System.out.println("int的最小值：" + Integer.MIN_VALUE);//int的最小值：-2147483648
        System.out.println("byte最大值：" + Byte.MAX_VALUE);//byte最大值：127
        System.out.println("byte最小值：" + Byte.MIN_VALUE);//byte最小值：-128
    }
}

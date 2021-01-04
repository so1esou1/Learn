package com.bjpowernode.javase.string;
/*
又一个面试题
  分析以下程序一共创建了几个对象
 */
public class StringTest03 {
    public static void main(String[] args) {
        /*
        ！！!一共3个对象:
            方法区字符串常量池中有1个："hello"
            堆内存当中有2个String对象
         */
        String s1 = new String("hello");
        String s2 = new String("hello");
    }
}

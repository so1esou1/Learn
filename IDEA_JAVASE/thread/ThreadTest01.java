package com.bjpowernode.java.thread;
/*
分析一下程序除垃圾回收线程之外，有几个线程？
    1个线程，程序只有一个栈
    一个栈中，自上而下的顺序依次逐行执行
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }
    private static void m1(){
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    private static void m3() {
        System.out.println("m3 execute");
    }

}

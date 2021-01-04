package com.bjpowernode.java.thread;
/*
实现线程的第二种方式，编写一个类，实现java.lang.Runnable接口，实现run方法。
 */
public class ThreadTest03 {
    public static void main(String[] args) {
        //创建一个可运行的对象
        //MyRunnable r = new MyRunnable();
        //将可运行对象封装成一个线程对象
        Thread t = new Thread(new MyRunnable());  //合并代码之后
        //启动线程
        t.start();
        for (int i = 0;i < 100;i ++){
            System.out.println("主线程 -- >" + i);
        }
    }
}
//这并不是一个线程的类，是一个可运行的类，还不是一个线程
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 100;i ++){
            System.out.println("分支线程 -- >" + i);
        }
    }
}

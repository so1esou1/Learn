package com.bjpowernode.java2.thread;
/*
    多线程的创建:
    方式一:继承于Thread类
        1、创建一个继承于Thread类的子类
        2、重写Thread类的run()方法 --> 将此线程执行的操作声明在run()方法中
        3、创建Thread类的子类的对象
        4、通过此对象调用start()方法
            start()方法的作用:启动当前线程+调用当前线程的run()方法
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //创建Thread类的子类的对象
        MyThread t1 = new MyThread();       //主线程做的

        //调用start()方法
        t1.start();                 //t1线程做的
        //t1.run();     //不能使用run()方法调用t1线程，仍然是在主线程调用的

        System.out.println("hello");        //主线程做的

        //在启动一个线程
        //t1.start();         //不能再启动一个，会报错IllegalThreadStateException

        //需要重新创建一个对象:
        MyThread t2 = new MyThread();
        t2.start();
    }
}


class MyThread extends Thread{
    //重写Thread类的run()方法
    public void run(){
        for (int i = 0;i < 100;i ++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}



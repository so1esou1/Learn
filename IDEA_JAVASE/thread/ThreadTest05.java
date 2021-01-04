package com.bjpowernode.java.thread;
/*
1、怎么获取当前线程对象？
    Thread t = Thread.currentThread();
    返回值t就是当前线程

2、获取线程对象的名字？
    String name = 线程对象.getName();

3、修改线程对象的名字？
    线程对象.setName("线程名字");

4、当线程没有设置名字的时候，默认的名字有什么规律？（了解）
    Thread-0
    Thread-1
    Thread-2
    Thread-3……………………

 */
public class ThreadTest05 {
    public static void main(String[] args) {

        //currentThread就是当前线程对象
        //出现在main方法中，当前线程就是主线程
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());  //主线程名字就叫main，用this、super代替currentThread也有同样的效果,最好还是用currentThread
        //当t1执行run方法，这个当前线程就是t1
        //当t2执行run方法，这个当前线程就是t2

        //创建线程对象
        MyThread2 t1 = new MyThread2();
        //设置线程名字
        t1.setName("tttt");
        //获取线程名字
        String tName = t1.getName();
        System.out.println(tName);//tttt，默认的名字是Thread-0
        //启动线程
        t1.start();

        MyThread2 t2 = new MyThread2();
        System.out.println(t2.getName());  //默认名字叫Thread-1
    }
}
class MyThread2 extends Thread{
    public void run(){
        for (int i = 0;i < 100;i ++){
            System.out.println("分支线程-->" + i);
        }
    }
}
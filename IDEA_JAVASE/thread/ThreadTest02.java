package com.bjpowernode.java.thread;
/*
实现线程的第一种方式：
    编写一个类，直接继承java.lang.Thread，重写run方法

    怎么创建线程对象？new就行了
    怎么启动线程？调用线程对象的start方法

    注意：亘古不变：方法体中的数据永远是自上而下依次执行的，永远不变

//以下程序的输出结果有这样的特点：
    有先有后
    有多有少
    这是为什么？？？？
    因为控制台只有一个，抢打印的控制权
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        //这里是main方法，这里的代码属于主线程，在主栈中运行
        //新建一个分支线程对象
        MyThread myThread = new MyThread();
        //myThread.run();  这里直接调用run方法不会启动线程，，不会分配新的栈
        //启动线程
        //***start方法的作用：在JVM中开辟一个新的栈空间，启动一个分支线程，这段代码任务完成之后瞬间就结束了，这段代码只是为了开辟一个新的栈空间，空间开出来start方法就结束了
        //启动成功的线程会自动调用run方法，并且run方法在分支栈的栈底部（压栈）
        //run方法在分支栈的栈底部，main方法在主栈的栈底部，run和main是平级的
        myThread.start();

        //这里的代码还是运行在主线程中
        for (int i = 0;i < 1000;i ++){
            System.out.println("主线程 -- >" + i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        //使用alt+insert，选择override-->run进行重写
        //在这里编写程序，这段程序运行在分支线程中（分支栈）
        for (int i = 0;i < 1000;i ++){
            System.out.println("分支线程--->" + i);
        }
    }
}


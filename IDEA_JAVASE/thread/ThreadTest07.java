package com.bjpowernode.java.thread;
/*
关于Thread.sleep()方法的一个面试题：
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        //创建线程对象
        Thread t = new MyThread3();
        t.setName("t");
        t.start();

        //调用sleep方法
        try {
            //问题：这行代码会让线程t进入休眠状态吗？
            t.sleep(1000*5);  //不会，在执行的时候还是会转换成：Thread.sleep(1000*5);
                                    //这行代码的作用是让当前线程进入休眠，也就是main方法进入休眠
                                    //这行代码出现在main方法中，main线程睡眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5秒之后这里会执行"hello world!"
        System.out.println("hello world!");
    }
}
class MyThread3 extends Thread{
    public void run(){
        for (int i = 0;i < 10000; i ++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
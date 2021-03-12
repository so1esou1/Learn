package com.bjpowernode.java2.thread;

import com.sun.jdi.ThreadReference;

/*
    守护线程
 */
public class ThreadTest17 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        //启动线程之前将线程设置为守护线程
        t.setDaemon(true);      //main线程结束，即使是死循环，t线程也会结束
        t.start();

        //主线程:主线程是用户线程
        for (int i =0;i < 10;i ++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class BakDataThread extends Thread{     //数据备份的方法

    @Override
    public void run() {
        //写一个死循环
        int i = 0;
        while (true){
            System.out.println(Thread.currentThread().getName() + "-->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
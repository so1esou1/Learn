package com.bjpowernode.java.thread;
/*
守护线程
    setDaemon()
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        //启动线程之前将线程设计成守护线程。非常简单
        t.setDaemon(true);
        t.start();

        //主线程：主线程是用户线程
        for (int i = 0;i < 10;i ++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class BakDataThread extends Thread{
    public void run(){   //写一个死循环
        int i = 0;
        //即使是死循环，但由于单线程是守护者，当用户线程结束，守护线程自动终止
        while(true){
            System.out.println(Thread.currentThread().getName() + "--->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

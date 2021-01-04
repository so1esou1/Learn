package com.bjpowernode.java.thread;
/*
在java中怎么强行终止一个线程？
    stop，存在很大缺点，没有保存的数据将会丢失，不建议使用
 */
public class ThreadTest09 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable3());
        t.setName("t");
        t.start();

        //模拟5秒
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5秒之后强行终止t线程
        //t.stop();  //已过时，不建议使用，类似于（任务管理器）强制关闭线程，容易损坏数据
    }
}
class MyRunnable3 implements Runnable{

    @Override
    public void run() {
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
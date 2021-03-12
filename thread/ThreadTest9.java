package com.bjpowernode.java2.thread;
/*
    同步方法处理继承Thread类的线程安全问题
 */
public class ThreadTest9 {
    public static void main(String[] args) {
        Window5 t1 = new Window5();
        Window5 t2 = new Window5();
        Window5 t3 = new Window5();
        //给三个窗口起名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}




class Window5 extends Thread{
    private static int ticket = 100;

    private static Object obj = new Object();
    @Override
    public void run() {
        while (true){
            show();
        }
    }


    public static synchronized void show(){        //此处同步监视器还是this，因此还无法做到线程同步，需要写成static静态方法
        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
            ticket --;
        }
    }
}

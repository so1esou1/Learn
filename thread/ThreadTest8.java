package com.bjpowernode.java2.thread;
/*
    使用同步方法解决实现Runnable接口的线程安全问题:

 */
public class ThreadTest8 {
    public static void main(String[] args) {
        Window4 w2 = new Window4();
        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}




class Window4 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){       //在此方法处加上synchronized修饰符，这种方式的话，默认的同步监视器是this
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

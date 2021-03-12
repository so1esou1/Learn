package com.bjpowernode.java2.thread;
/*
    使用Runnable接口的方式，实现窗口卖票
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window1 implements Runnable{
    private int ticket = 100;       //这里没有加static，但是t1 t2 t3共用这100张票，因为只造了一个对象，放到了3个构造器之中，三个线程都是用的同一个window1
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
                ticket --;
            }else {
                break;
            }
        }
    }
}



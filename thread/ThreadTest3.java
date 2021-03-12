package com.bjpowernode.java2.thread;
/*
    多线程案例:三个窗口卖票,总票数为100张，使用的继承类的方式做的
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        //给三个窗口起名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
        //会出现严重的重票问题
    }
}


class Window extends Thread{
    private static int ticket = 100;       //定义100张票,使用static作修饰，这样总共就只有100张票
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

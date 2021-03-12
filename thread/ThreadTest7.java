package com.bjpowernode.java2.thread;
/*
    同步代码块处理继承Thread类的线程问题:
 */
public class ThreadTest7{
    public static void main(String[] args) {
        Window3 t1 = new Window3();
        Window3 t2 = new Window3();
        Window3 t3 = new Window3();
        //给三个窗口起名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Window3 extends Thread{
    private static int ticket = 100;

    //private Object obj = new Object();        //继承的话，这里的锁对象就不唯一，每个线程都会new一个obj对象
    //需要static修饰
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true){
            //synchronized(obj){          //继承的方式这里就不能写this锁
            //但是可以使用反射机制
            synchronized(Window3.class){        //类充当同步监视器，说明类也是一种对象,类只会加载一次，意味着只有一个
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
                    ticket --;
                }else {
                    break;
                }
            }
        }
    }
}
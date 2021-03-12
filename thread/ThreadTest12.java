package com.bjpowernode.java2.thread;

import java.util.concurrent.locks.ReentrantLock;

/*
    解决线程安全问题的方式三:Lock锁

    Lock锁，JDK5.0开始，Java提供了更强大的线程同步机制——通过显式定义同步锁对象来实现同步。
    同步锁使用Lock对象充当

    java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。
    提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应先获得Lock对象

    ReentrantLock 类实现了 Lock ，它拥有与 synchronized 相同的并发性和内存语义，
    在实现线程安全的控制中，比较常用的是ReentrantLock，可以显式加锁、释放锁

 */
public class ThreadTest12 {
    public static void main(String[] args) {
        Window6 w = new Window6();
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


class Window6 implements Runnable{
    private int ticket = 100;
    //1、实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //2、调用锁定lock()方法
                lock.lock();

                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":售票,票号为:" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3、调用解锁的方法unlock()
                lock.unlock();
            }
        }
    }
}



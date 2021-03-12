package com.bjpowernode.java2.thread;
/*
    线程通信测试
    涉及到的三个方法:
    wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
    notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的线程
    notifyAll():一旦执行此方法，就会唤醒所有被wait的线程

    使用的前提:这些方法的调用都得在同步代码块或同步方法中，lock()方法无法使用这种方式，有其他方式
            这三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现异常
 */
public class ThreadTest13 {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}



class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();       //唤醒方法，不用notifyAll()方法，因为两个线程会互相唤醒，如果是三个线程以上就要用notifyAll

                if (number <= 100){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number ++;

                    try {
                        wait();         //使得调用如下wait方法的线程进入阻塞状态,wait方法还会释放锁,notify方法可以结束wait状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
    //这段代码中，线程1和线程2会交替进入
}

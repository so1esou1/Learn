package com.bjpowernode.java.deadlock;
/*
死锁代码要会写，面试要求，只有会写才会在以后的开发中注意这个事，因为死锁很难调试

    这个程序有可能运行良好，在两个方法刚好同时执行完一次的时候
    synchronized在开发中最好不要嵌套使用，一不小心就可能导致死锁现象的发生
 */
public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        //t1、t2两个线程共享o1、o2
        Thread t1 = new MyThread1(o1,o2);
        Thread t2 = new MyThread2(o1,o2);

        t1.start();
        t2.start();
    }
}
//两个对象共享o1和o2
class MyThread1 extends Thread{
    Object o1;
    Object o2;
    public MyThread1(Object o1,Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public void run(){
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//加上睡眠的话，一定会出问题
            synchronized (o2){

            }
        }
    }
}

class MyThread2 extends Thread{
    Object o1;
    Object o2;
    public MyThread2(Object o1,Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public void run(){
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }
    }
}
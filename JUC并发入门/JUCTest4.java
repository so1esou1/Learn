package com.csu.juc;



/*
    线程之间的通信问题:生产者和消费者问题
    线程交替执行  A  B操作同一个变量  必须线程间实现通信:通知唤醒、等待唤醒
 */
public class JUCTest4 {
    public static void main(String[] args) {
        Data data = new Data();
        //两对生产者和消费者的话，会出现问题，不能实现1、0的交替
        //因为走了if判断，if判断只判断一次，需要使用while循环
        new Thread(() -> {
            for (int i = 0;i < 10;i ++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0;i < 10;i ++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0;i < 10;i ++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for (int i = 0;i < 10;i ++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}



//等待+业务+通知
class Data{     //数字，资源类
    private int number = 0;

    //+1操作:
    public synchronized void increment() throws InterruptedException {
        if (number != 0){
            //等待操作
            this.wait();
        }
        number ++;
        //通知其他线程，我+1完毕了
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "=>" + number);   //看现在是哪个线程
    }
    //-1操作:
    public synchronized void decrement() throws InterruptedException {
        if (number == 0){
            //等待
            this.wait();
        }
        number --;
        //通知其他线程，我-1完毕了
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "=>" + number);   //看现在是哪个线程
    }
}

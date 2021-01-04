package com.bjpowernode.java.thread;

import java.util.ArrayList;
import java.util.List;

/*
适使用wait方法和notify方法实现生产者和消费者模式
生产线程负责生产，消费线程负责消费，生产消费要达到均衡，在这种特殊的业务需求情况下要使用wait和notify方法

wait方法和notify方法建立在线程同步的基础之上，因为多线程要同时操作一个仓库，有线程安全问题

模拟这样一个需求：
    仓库采用list集合，list集合假设只能存储一个元素，1个元素就代表仓库满了，0表示空了
    保证list集合中永远都是最多存储一个元素，生产一个消费一个
 */
public class ThreadTest16 {
    public static void main(String[] args) {
        //创建一个仓库对象,共享的
        List list = new ArrayList();
        //创建两个线程对象
        //生产者线程
        Thread t1 = new Thread(new Producer(list));
        //消费者线程
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}
//生产线程
class Producer implements Runnable{
    //仓库
    private List list;

    public Producer(List list){
        this.list = list;
    }
    @Override
    public void run() {
        //一直生产(使用死循环来模拟一直生产)
        while (true){
            synchronized (list){   //表示给仓库对象list加锁
                if (list.size() > 0){
                    //当前线程进入等待状态,>0说明当前仓库已经有一个元素了
                    try {
                        list.wait();//生产线程进入等待状态，并且释放掉list的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序能够执行到这里说明仓库是空的，可以生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                //唤醒消费者进行消费
                list.notify();   //用notifyAll也没关系，唤醒之后不会释放锁
            }

        }
    }
}
//消费线程
class Consumer implements Runnable{
    //仓库
    private List list;
    public Consumer(List list){
        this.list = list;
    }
    @Override
    public void run() {
        //一直消费（使用死循环来模拟一直消费）
        while (true){
            synchronized (list){
                if (list.size() == 0){
                    //仓库已经空了,不能继续消费，消费等待，释放掉list集合的锁
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序执行到此处，说明仓库中有数据，进行消费
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                //唤醒生产者生产
                list.notify();
            }
        }
    }
}

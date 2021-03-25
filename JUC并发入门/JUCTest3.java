package com.csu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    使用Lock锁的方式:
 */
public class JUCTest3 {
    public static void main(String[] args) {
        //并发:多线程操作同一个类,把资源类丢入线程即可:
        Ticket2 ticket2 = new Ticket2();

        //lambda表达式(参数)->{代码}
        new Thread(()->{
            for (int i = 1;i < 40;i ++){
                ticket2.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1;i < 40;i ++){
                ticket2.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1;i < 40;i ++){
                ticket2.sale();
            }
        },"C").start();
    }
}


//资源类   OOP编程
class Ticket2{
    //属性、方法
    private int number = 30;

    Lock lock = new ReentrantLock();
    //卖票的方式:
    public void sale(){
        //1、用之前加锁
        lock.lock();
        try {
            //2、业务代码写在这
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "张票,剩余" + (number));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //3、用完之后解锁
            lock.unlock();
        }
    }
}

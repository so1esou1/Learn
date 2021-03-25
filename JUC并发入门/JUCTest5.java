package com.csu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    使用lock版的生产者和消费者
 */
public class JUCTest5 {
    public static void main(String[] args) {
        Data2 data = new Data2();

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
class Data2{     //数字，资源类
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //+1操作:
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //业务代码
            while (number != 0){
                //等待操作
                condition.await();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);   //看现在是哪个线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }



    }
    //-1操作:
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //业务代码
            while (number == 0){
                //等待
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + "=>" + number);   //看现在是哪个线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
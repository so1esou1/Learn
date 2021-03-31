package com.csu.juc.producercustomer;

import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    生产者消费者传统版
 */
public class pc1 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        //A线程做加法
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        //B线程做减法
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}



class ShareData{        //资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产增加的方法
    public void increment() throws Exception{
        lock.lock();

        try {
            //1、判断:
            while (number != 0){    //一开始为真
                //等待，不能生产
                condition.await();
            }

            //2、干活:
            number ++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //3、通知唤醒:
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //消费减少的方法
    public void decrement() throws Exception{
        lock.lock();

        try {
            //1、判断:
            while (number == 0){
                //等待，不能消费
                condition.await();
            }

            //2、进行消费:
            number --;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //3、通知唤醒:
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

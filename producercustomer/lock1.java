package com.csu.juc.producercustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    lock实现绑定多个条件Condition的案例

    要求:AA打印5此，再BB打印10次，再CC打印15次
    接着，再次:
    AA打印5此，再BB打印10次，再CC打印15次
    循环10轮
 */
public class lock1 {
    public static void main(String[] args) {
        ShareData1 shareData1 = new ShareData1();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareData1.print5();
            }
        },"A").start();


        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareData1.print10();
            }
        },"B").start();


        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareData1.print15();
            }
        },"C").start();
    }
}


class ShareData1{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    //创建3个condition
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();

        try {
            //1、判断
            while (number != 1){
                c1.await();     //A暂停
            }
            //2、打印:
            for (int i = 1;i <=5; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3、通知:
            number = 2;
            c2.signal();        //只通知c2唤醒

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void print10(){
        lock.lock();

        try {
            //1、判断
            while (number != 2){
                c2.await();     //B暂停
            }
            //2、打印:
            for (int i = 1;i <=10; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3、通知:
            number = 3;
            c3.signal();        //只通知c3唤醒

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void print15(){
        lock.lock();

        try {
            //1、判断
            while (number != 3){
                c3.await();     //C暂停
            }
            //2、打印:
            for (int i = 1;i <=15; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3、通知:
            number = 1;
            c1.signal();        //只通知c1唤醒

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

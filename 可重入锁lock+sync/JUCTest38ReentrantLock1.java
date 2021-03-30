package com.csu.juc.cas;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    可重入锁:
 */
public class JUCTest38ReentrantLock1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sms();
        },"A").start();


        new Thread(()->{
            phone.call();
        },"B").start();
    }
}


class Phone{
    Lock lock = new ReentrantLock();

    public void sms(){
        lock.lock();            //细节问题:两把锁，同时拿到sms的锁和下面调用的call()方法的锁
        //lock上锁必须配对一个解锁，否则会出现死锁
        try {
            System.out.println(Thread.currentThread().getName() + "sms");
            call();     //这里进去也有锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

package com.csu.juc.cas;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
    自定义一个自旋锁
 */
public class JUCTest39SpinLock1 {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁:
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> mylock");

        while (!atomicReference.compareAndSet(null,thread)){     //如果是空的，就把线程放进去无限循环，这就是自旋锁


        }
    }

    //解锁:
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> mylock");

        atomicReference.compareAndSet(thread,null);
    }


    //进行测试:
    public static void main(String[] args) throws InterruptedException {
        JUCTest39SpinLock1 lock = new JUCTest39SpinLock1();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"T1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }

        },"T2").start();
    }
}

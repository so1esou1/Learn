package com.csu.juc.cas;

/*
    可重入锁的隐式锁版
 */
public class JUCTest38ReentrantLock2 {
    static Object objectLockA = new Object();

    public static void m1(){
        new Thread(()->{
            synchronized (objectLockA){         //都是调用的同一把锁
                System.out.println(Thread.currentThread().getName() + "\t" + "----外层调用");
                synchronized (objectLockA){
                    System.out.println(Thread.currentThread().getName() + "\t" + "----中层调用");
                    synchronized (objectLockA){
                        System.out.println(Thread.currentThread().getName() + "\t" + "----内层调用");
                    }
                }
            }
        },"t1").start();
    }

    public static void main(String[] args) {
        m1();
    }
}

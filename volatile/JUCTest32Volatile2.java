package com.csu.juc;

import java.util.concurrent.atomic.AtomicInteger;

/*
    volatile的不保证原子性
 */
public class JUCTest32Volatile2 {
    private static int num = 0;
    //原子类的int:
    //private volatile static AtomicInteger num = new AtomicInteger();

    public synchronized static void add(){      //synchronized可以保证原子性
        num ++;
    }

    public static void main(String[] args) {
        //理论上结果应该为20000
        for (int i = 1;i <= 20;i ++){
            new Thread(()->{
                for (int j = 0;j < 1000;j ++){
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){     //main线程和gc线程是默认执行的
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}

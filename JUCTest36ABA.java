package com.csu.juc.cas;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
    CAS的ABA问题
 */
public class JUCTest36ABA {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //对于我们平时写的sql：乐观锁

        //捣乱的线程
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021,2020));
        System.out.println(atomicInteger.get());


        //期望执行的线程
        try {
            TimeUnit.SECONDS.sleep(2);      //先睡一会，保证捣乱的线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.compareAndSet(2020,6666));
        System.out.println(atomicInteger.get());

    }
}

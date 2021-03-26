package com.csu.juc;

import java.util.concurrent.CountDownLatch;

/*
    减法计数器:countDownLatch
 */
public class JUCTest15CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);      //总数是6
        for (int i = 1;i <= 6;i ++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "Go out");
                countDownLatch.countDown();         //数量-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();     //等待计数器归零，然后再向下执行
        //一定会将以上的执行完毕才输出下面的
        System.out.println("close door");
    }
}

package com.csu.juc;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/*
    同步队列
    和其他BlockingQueue不一样，SynchronousQueue不存储元素
    put了一个元素，必须先取出来，否则不能再put进去值
 */
public class JUCTest21SynchronousQueue {
    public static void main(String[] args) {
        SynchronousQueue<String> sq = new SynchronousQueue<>();   //创建同步队列

        //存放的线程
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "put 1");
                sq.put("1");
                System.out.println(Thread.currentThread().getName() + "put 2");
                sq.put("2");
                System.out.println(Thread.currentThread().getName() + "put 3");
                sq.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        //取得线程
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"->" + sq.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"->" + sq.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"->" + sq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}

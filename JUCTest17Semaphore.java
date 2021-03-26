package com.csu.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
    Semaphore工具类
 */
public class JUCTest17Semaphore {
    public static void main(String[] args) {
        //线程数量:停车位
        Semaphore semaphore = new Semaphore(3);        //3个停车位
        for (int i = 1;i <= 6;i ++){
            new Thread(()->{
                //acquire()得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(2);  //停两秒钟
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //release()释放
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}

package com.csu.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    线程池1，使用Executors创建线程(实际工作中不建议)
    Executors工具类:3大方法
 */
public class JUCTest22Pool1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();   //创建一个单一线程的池
        //Executors.newFixedThreadPool(5);    //创建一个固定大小的线程池，大小为5
        //Executors.newCachedThreadPool();            //创建可伸缩的线程池

        try {
            for (int i = 0;i < 10;i ++){
                //使用线程池的方式创建线程:
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完一定要记得关闭线程池:
            threadPool.shutdown();
        }


    }
}




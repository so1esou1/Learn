package com.bjpowernode.java2.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
    创建线程的方式四:使用线程池创建线程

    方法:
    Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
        Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
        Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
        Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池
        Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。

    ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
        void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行Runnable
        <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般又来执行Callable
        void shutdown() ：关闭连接池

 */
public class ThreadTest16 {
    public static void main(String[] args) {
        //1、提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);     //多态机制


        //执行前可以设置线程的属性（接口ExecutorService的设置属性过少，要通过接口的实现类对象来设置）
        System.out.println(service.getClass());     //class java.util.concurrent.ThreadPoolExecutor类型
        //进行强转:
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //使用service1进行设置:
        //service1.setCorePoolSize(15); 核心池的大小
        //service1.setKeepAliveTime();  存活时长
        //service1.setMaximumPoolSize();    设置最大线程数

        //2、执行指定的线程的操作，需要提供实现Runnable或Callable接口实现类的对象
        service.execute(new NumberThread());      //适合使用于Runnable
        //service.submit();                     //适合使用于Callable
        service.execute(new NumberThread2());

        //3、关闭连接池
        service.shutdown();     //关闭线程池
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i <= 100;i ++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);     //pool-1-thread-1:0
            }
        }
    }
}


class NumberThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i <= 100;i ++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);     //pool-1-thread-1:0
            }
        }
    }
}

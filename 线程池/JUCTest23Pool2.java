package com.csu.juc;

import java.util.concurrent.*;

/*
    自定义一个线程池，需要记住这7个参数
 */
public class JUCTest23Pool2 {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,          //核心线程池大小
                5,      //最大核心线程池大小，多出来3个是备用的
                3,          //超时时间，超过3s后，原来创建出来的备用的3个线程池被销毁
                TimeUnit.SECONDS,           //时间的单位
                new LinkedBlockingQueue<>(),        //一个链表阻塞队列,如果线程池满了还有人进来就先存放在这里
                Executors.defaultThreadFactory(),       //线程工厂，创建线程的，一般不用动
                new ThreadPoolExecutor.AbortPolicy()    //拒绝策略，如果线程池+队列满了还有人进来就不出来这个人的了，且抛出异常
        );

        try {
            //最大承载:Deque+max
            for (int i = 1;i < 5;i ++){
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

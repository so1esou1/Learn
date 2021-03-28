package com.csu.juc;

import java.util.concurrent.*;

/*
    异步回调:我们最开始学的是AJAX
        异步执行
        成功回调
        失败回调
    使用CompletableFuture()
 */
public class JUCTest30Future1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求:

        //没有返回值的runAsync异步回调
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=>Void");
        });

        completableFuture.get();            //因为前面睡了，所以正常来说这里会阻塞获取执行结果*/


        //有返回结果的异步回调:
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "supplyAsync=>Integer");
            int i = 10/0;
            return 1024;
        });

        System.out.println(completableFuture.whenComplete((t,u)->{
            System.out.println("t=>" + t);      //正常的返回结果
            System.out.println("u=>" + u);
        }).exceptionally((e)->{     //错误的返回结果
            e.printStackTrace();
            return 404;
        }).get());
    }
}

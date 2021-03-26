package com.csu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
    CycliBarrier类
 */
public class JUCTest16CycliBarrier {
    public static void main(String[] args) {
        //召唤神龙的线程:
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });

        for (int i = 1;i <= 7;i ++){
            //lambda表达式不能直接操作到i
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集" + temp + "个龙珠");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}

package com.csu.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/*
    CAS锁
 */
public class JUCTest35CAS1 {

    //原子类的底层使用的是CAS
    //CAS:
    public static void main(String[] args) {
        //创建一个原子类:
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        //compareAndSet()比较并交换
        atomicInteger.compareAndSet(2020,2021);     //如果期望的值达到了就更新，否则不更新
        System.out.println(atomicInteger.get());        //2021
        /*
            源码:
            public final boolean compareAndSet(int expect, int update) {
                return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
            }
         */
        System.out.println(atomicInteger.compareAndSet(2020,2021));     //输出false，修改失败

        //CAS是CPU的并发原理
    }
}

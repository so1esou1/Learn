package com.csu.juc.cas;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;


/*
    虚引用
 */
public class PhantomReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        //创建一个引用队列:
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        //虚引用套着一个监控对象，监控这个对象的引用信息
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);     //java.lang.Object@1b6d3586
        System.out.println(phantomReference.get());     //null
        System.out.println(referenceQueue.poll());      //null


        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);             //null
        System.out.println(phantomReference.get());     //null
        System.out.println(referenceQueue.poll());      //java.lang.ref.PhantomReference@4554617c
    }
}

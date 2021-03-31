package com.csu.juc.cas;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author so1esou1
 * @ClassName
 * @Date 2021.1.4
 * @TODO
 */
public class RefQueue {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        //创建一个引用队列:
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        //创建一个弱引用:
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);         //java.lang.Object@1b6d3586
        System.out.println(weakReference.get());        //java.lang.Object@1b6d3586
        System.out.println(referenceQueue.poll());      //null



        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);             //null
        System.out.println(weakReference.get());    //null
        System.out.println(referenceQueue.poll());  //java.lang.ref.WeakReference@4554617c
        //软、弱、虚引用都有一种机制:在GC回收前，会被放到引用队列中保存下
    }


}

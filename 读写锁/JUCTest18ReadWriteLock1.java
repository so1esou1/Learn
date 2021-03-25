package com.csu.juc;

import java.util.HashMap;
import java.util.Map;

/*
    读写锁ReadWriteLock,没加锁的状态，写入时会被线程插入
 */
public class JUCTest18ReadWriteLock1 {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //创建几个线程来测试:
        //5个写入的线程:
        for (int i = 1;i <= 5;i ++){
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //5个读取的线程:
        for (int i = 1;i <= 5;i ++){
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}


//自定义一个缓存:
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();

    //存,写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");
    }

    //取，读
    public void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕");
    }
}


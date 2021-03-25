package com.csu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
    读写锁ReadWriteLock,加了锁的状态
 */
public class JUCTest19ReadWriteLock2 {
    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
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
class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    //创建一把读写锁,更加细粒度地控制:
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //存,写,写入的时候只希望同时只有一个线程写:
    public void put(String key,Object value){
        //添加一把写锁,比lock能更加细粒度地控制:
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();     //解锁
        }
    }

    //取，读,所有人都可以进行读
    public void get(String key){
        //创建一个读锁
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
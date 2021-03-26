package com.csu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
    map集合不安全,ConcurrentModificationException异常
 */
public class JUCTest13Map {
    public static void main(String[] args) {

        /*Map<String, String> map = new HashMap<>();
        //工作中不太使用HashMap
        //加载因子、初始化容量

        for (int i = 1;i <= 30;i ++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
         */

        /*
            解决方案:1、Collections.synchronized,不谈了
                    2、ConcurrentHashMap类，比HashMap和HashSet好用
         */
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1;i <= 30;i ++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}

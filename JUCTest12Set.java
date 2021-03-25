package com.csu.juc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/*
    set集合不安全，ConcurrentModificationException异常
 */
public class JUCTest12Set {
    public static void main(String[] args) {
        /*Set<String> set = new HashSet<>();
        for (int i = 0;i <= 10;i ++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
         */

        /*
            解决方案:1、Collections.synchronized
                    2、CopyOnWriteArraySet
         */
        //1、Collections.synchronized:
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0;i <= 10;i ++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

        //2、CopyOnWriteArraySet:
        Set<String> set2 = new CopyOnWriteArraySet<>();
        for (int i = 0;i <= 10;i ++){
            new Thread(()->{
                set2.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set2);
            },String.valueOf(i)).start();
        }

    }
}

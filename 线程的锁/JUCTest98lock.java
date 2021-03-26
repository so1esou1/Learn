package com.csu.juc;

import java.util.concurrent.TimeUnit;

/*
    5、增加两个静态的同步方法,先发短信还是打电话？        发短信
        static静态方法，类一开始就有了，锁的是Class
    6、两个对象，先发短信还是打电话？           发短信
        两个对象的Class类模板只有一个，static锁的是Class
 */
public class JUCTest98lock {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        Phone3 phone2 = new Phone3();

        //这里两个线程的锁都是phone对象，谁先拿到谁执行
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);          //使用JUC中的休息方法，休息1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
            //phone2.call();
        },"B").start();
    }
}


class Phone3{


    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }
}
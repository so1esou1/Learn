package com.csu.juc;

import java.util.concurrent.TimeUnit;

/*
    7、1个静态的同步方法，1个普通的同步方法。先发短信还是打电话？        打电话再发短信
        static锁的是Class模板，普通方法锁的是调用者，用的不是同一个锁

    8、1个静态的同步方法，1个普通的同步方法，两个对象。先发短信还是打电话？       打电话
 */
public class JUCTest108lock {
    public static void main(String[] args) {
        Phone4 phone4 = new Phone4();
        Phone4 phone5 = new Phone4();

        new Thread(()->{
            phone4.sendSms();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone4.call();
            //phone5.call();
        }).start();
    }
}



class Phone4{

    //静态同步方法:
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //没有static的普通同步方法:
    public synchronized void call(){
        System.out.println("打电话");
    }
}

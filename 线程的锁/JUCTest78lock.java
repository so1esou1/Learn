package com.csu.juc;

import java.util.concurrent.TimeUnit;

/*
8锁就是关于锁的8个问题
    1、标准情况下，两个线程是先发短信还是打电话？     发短信之后才是打电话
    2、假如sendSms休息4秒，是先发短信还是打电话？     还是发短信，因为sendSms先抢到锁，虽然睡眠了，但是线程是阻塞的
 */
public class JUCTest78lock {
    public static void main(String[] args) {
        Phone phone = new Phone();

        //这里两个线程的锁都是phone对象，谁先拿到谁执行
        new Thread(()->{
            phone.sendSms();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);          //使用JUC中的休息方法，休息1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        }).start();
    }
}

class Phone{
    //synchronized 锁的对象是方法的调用者

    public synchronized void sendSms(){
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
}

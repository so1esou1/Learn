package com.csu.juc;

import java.util.concurrent.TimeUnit;

/*
    3、第二个线程执行的方法没有被synchronized修饰了，现在是先发短信还是打电话？    hello
        hello方法没有锁，第一个方法睡眠，肯定走hello方法，不受锁的影响
    4、使用两个对象，Phone2，现在是先发短信还是打电话        先执行打电话，之后发短信

 */
public class JUCTest88lock {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
            phone.sendSms();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.hello();
            //phone2.call();        //先执行打电话，之后发短信
        }).start();
    }
}



class Phone2{


    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}
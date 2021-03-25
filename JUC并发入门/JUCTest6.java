package com.csu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Condition实现精准通知和唤醒

    要求:A执行完调用B，B完调用C，C完调用A
 */
public class JUCTest6 {
    public static void main(String[] args) {
        Data3 data3 = new Data3();

        new Thread(()->{
            for (int i = 0;i < 10;i ++){
                data3.printA();
            }
        },"A").start();


        new Thread(()->{
            for (int i = 0;i < 10;i ++){
                data3.printB();
            }
        },"B").start();


        new Thread(()->{
            for (int i = 0;i < 10;i ++){
                data3.printC();
            }
        },"C").start();
    }
}



class Data3{        //资源类
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int number = 1; //number为1是A执行，2B,3C

    public void printA(){
        lock.lock();
        try {
            //业务代码  判断->执行->通知
            while (number != 1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAAA");
            //唤醒指定的B
            number = 2;
            condition2.signal();        //精准唤醒

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void printB(){
        lock.lock();
        try {
            //业务代码  判断->执行->通知
            while (number != 2){
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBBBB");
            //唤醒指定的C
            number = 3;
            condition3.signal();        //精准唤醒

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void printC(){
        lock.lock();
        try {
            //业务代码  判断->执行->通知
            while (number != 3){
                //等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCCCCCC");
            //唤醒指定的C
            number = 1;
            condition1.signal();        //精准唤醒

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

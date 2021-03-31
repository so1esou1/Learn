package com.csu.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/*

 */
public class AQS1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        //A顾客是第一个顾客，此时窗口没有任何人，A可以直接去办理
        new Thread(()->{
            lock.lock();

            try {
                System.out.println("------A thread come in");
                //暂停几秒
                TimeUnit.MINUTES.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"A").start();


        //B顾客是第二个顾客，窗口只有一个，B只能等待，进入候客区
        new Thread(()->{
            lock.lock();

            try {
                System.out.println("------B thread come in");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"B").start();


        //C顾客是第三个顾客，C只能等待，进入候客区
        new Thread(()->{
            lock.lock();

            try {
                System.out.println("------C thread come in");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"C").start();
    }
}

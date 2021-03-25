package com.csu.juc;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

/**
 * 基本的卖票例子,使用传统的synchronized方式解决
 */

/*
    真正的业务中多线程开发，不会使用Runnable、Thread等实现、继承，这种方式耦合性高
    线程就是一个单独的资源类，没有任何附属的操作!
        1、属性+方法
 */
public class JUCTest2 {
    public static void main(String[] args) {
        //并发:多线程操作同一个类,把资源类丢入线程即可:
        Ticket ticket = new Ticket();

        //lambda表达式(参数)->{代码}
        new Thread(()->{
            for (int i = 1;i < 40;i ++){
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1;i < 40;i ++){
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1;i < 40;i ++){
                ticket.sale();
            }
        },"C").start();
    }
}

//资源类   OOP编程
class Ticket{
    //属性、方法
    private int number = 50;

    //卖票的方式:
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "张票,剩余" + (number));
        }
    }
}

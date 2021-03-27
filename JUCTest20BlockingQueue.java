package com.csu.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
    BlockingQueue的四组API
 */
public class JUCTest20BlockingQueue {
    public static void main(String[] args) {
        test1();
        test2();

        try {
            test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            test4();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
        抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3); //队列的大小能放3个参数

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //System.out.println(blockingQueue.add("d"));     队列已满，此时添加会抛出异常

        System.out.println(blockingQueue.element());        //查看队首元素是什么

        System.out.println(blockingQueue.remove());     //是按照FIFO原则，即先进先出的顺序移除的
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //System.out.println(blockingQueue.remove());     已经没有元素了，会抛出异常
    }



    /*
        不抛出异常，有返回值
     */
    public static void test2(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println(blockingQueue.peek());       //检测队首元素

        System.out.println(blockingQueue.offer("d"));       //不会抛出异常，会返回false布尔值

        System.out.println(blockingQueue.poll());       //移除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.poll());       //返回null，不抛出异常
    }


    /*
        等待，阻塞(一直阻塞、等待，等到死)
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        //一直阻塞
        blockingQueue.put("a");     //存入
        blockingQueue.put("b");
        blockingQueue.put("c");

        blockingQueue.put("d");     //队列已经没有位置了,会一直等待

        //存入
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());       //没有这个元素
    }



    /*
        等待，阻塞(等待超时)
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d",2,TimeUnit.SECONDS);     //只等待2秒，2秒之后超时退出

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS)); //超过2秒就不再等待了，退出
    }
}

package com.csu.juc.producercustomer;

import java.awt.geom.FlatteningPathIterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
    阻塞队列下的生产者和消费者
 */
public class pc2 {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(3));    //创建一个容量为3的阻塞队列
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "生产线程启动");
            try {
                myResource.myProd();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "消费线程启动");
            try {
                myResource.myCons();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Cons").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5s时间到，main线程叫停，活动结束");
        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class MyResource{
    private volatile boolean FLAG = true;       //默认开启，进行生产和消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd()throws Exception{
        String data = null;
        boolean retValue;
        //生产:
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);     //超时时间设定为2s
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        //如果FLAG是false:
        System.out.println(Thread.currentThread().getName() + "FLAG=false，生产工作结束");
    }


    public void myCons() throws Exception{
        String result = null;
        //消费:
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){     //如果队列中为空
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "超过2s没有收到，消费退出");
                System.out.println();
                return;
            }

            System.out.println(Thread.currentThread().getName() + "消费队列" + result + "成功");
        }
    }

    public void stop()throws Exception{
        this.FLAG = false;
    }
}

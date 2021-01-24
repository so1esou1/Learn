package com.csu.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/*
ThreadLocal示例
 */
public class ThreadLocalTest {

    public final static Map<String,Object> data = new Hashtable<String,Object>();
    private static Random random = new Random();

    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static class Task implements Runnable{
        /*
        threadlocal.set("abc");
        threadlocal.set("bbj");
        System.out.println(threadlocal.get());//因为threadlocal对象，只能为当前线程关联一个数据。输出结果是bbj,由最后一个值覆盖
         */




        @Override
        public void run() {
            //在run方法中随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]生成的随机数是：" + i);
           // data.put(name,i);
            threadLocal.set(i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();


            //在run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            //Object o = data.get(name);

            Object o = threadLocal.get();
            System.out.println("在线程[" + name + "]快结束时取出关联的数据是:" + o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 3; i ++){
            new Thread(new Task()).start();
        }
    }
}

package com.bjpowernode.java.thread;
/*
关于线程的sleep方法
    static void sleep(long millis)
    1、静态方法
    2、参数是毫秒
    3、作用：让当前线程进入休眠状态，进入“阻塞状态”，放弃占用的cpu时间片，让给其他线程使用
       出现在哪就让哪个线程进入休眠状态
    4、Thread.sleep()方法可以做到这种效果：
        间隔特定时间执行特定的代码，每隔多久执行一次
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        /*//让当前线程进入休眠，睡眠5秒
        //当前线程是主线程！！！
        try {
            Thread.sleep(1000*5);  //sleep有异常需要处理的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5秒之后执行这里的代码
        System.out.println("hello world!");
        */

        for (int i = 0;i < 10;i ++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            //睡眠1秒，执行结果是0-9每个值间隔1秒输出
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.bjpowernode.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;  //JUC包下的，属于java的并发包，老版没有

/*
实现线程的第三种方式：
    实现callable接口

    缺点：效率较低，会阻塞
    优点：能获得线程的执行结果
 */
public class ThreadTest15 {
    public static void main(String[] args) throws Exception{
        //第一步：实现一个“未来任务类”对象
        //参数非常重要，需要给一个Callable接口的实现对象
        FutureTask task = new FutureTask(new Callable() {    //采用匿名内部类
            @Override
            public Object call() throws Exception {   //call()方法相当于run方法，只不过这个有返回值
                //线程执行一个任务，执行之后可能会有一个返回结果
                //模拟执行
                System.out.println("call method begin");
                Thread.sleep(1000 * 10);
                System.out.println("call method end!");
                int a = 100;
                int b = 200;
                return a + b;//自动装箱（300结果变成Integer）
            }
        });
        //创建线程对象
        Thread t = new Thread(task);

        //启动线程
        t.start();

        //这里是main方法，这是在主线程中
        //在主线程中怎么获取t线程的返回结果
        Object obj = task.get();
        //这个get方法的执行会不会让当前线程阻塞？会
        System.out.println("线程执行结果：" + obj);

        //main方法这里的程序执行必须等待get()方法的结束
        //而get()方法可能需要执行很久，因为get()方法是为了拿另一个线程的执行结果，另一个线程的执行是需要时间的
        System.out.println("hello world！");

    }
}

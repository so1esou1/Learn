package com.bjpowernode.java2.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
    创建线程的方式三:实现Callable接口的方式  ----JDK5.0新增


 */
public class ThreadTest15 {
    public static void main(String[] args) {
        //3、创建Callable接口的实现类对象
        NumThread numThread = new NumThread();
        //4、通过FutureTask类创建线程，将此Callable接口的实现类对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5、将FutureTask的对象作为参数传递到Thread类中，创建Thread对象，并调用start()
        new Thread(futureTask).start();     //FutureTask也实现了Runnable接口,这段代码启动线程

        //下面这段代码只是为了获得方法的返回值
        //6、获取Callable中call方法的返回值
        try {
            Object sum = futureTask.get();      //futureTask.get()可以获取numThread的回调结果
            System.out.println("总和为:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


//1、创建一个实现Callable接口的实现类
class NumThread implements Callable{
    //2、实现call方法(相当于run方法)，将此线程需要做的事声明在call中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1;i <= 100;i ++){
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

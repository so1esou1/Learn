package com.csu.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
    callable示例
    Runnable功能有限
 */
public class JUCTest14Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();

        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);   //FutureTask是Runnable的适配类
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();     //结果会被缓存，效率高
        Integer o = (Integer)futureTask.get();      //获取Callable的值
        //这个get()方法可能产生阻塞，把它放到最后，或者使用异步通信(就像AJAX)处理
    }
}


//Callable泛型的类型就是call()方法返回值的类型
class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}

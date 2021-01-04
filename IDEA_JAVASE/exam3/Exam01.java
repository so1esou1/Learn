package com.bjpowernode.java.exam3;
/*
面试题：

 */
public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        //更改了下调用的对象，这次需不需要等待？
        MyClass mc1 = new MyClass();
        MyClass mc2 = new MyClass();
        Thread t1 = new MyThread(mc1);
        Thread t2 = new MyThread(mc2);
        //不需要，因为MyClass对象是两把锁，各自执行各自的

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        Thread.sleep(1000);   //这个睡眠的作用是保证t1线程先执行。
        t2.start();
    }
}

class MyThread extends Thread{
    private MyClass mc;
    public MyThread(MyClass mc){
        this.mc = mc;
    }
    public void run(){
        if (Thread.currentThread().getName().equals("t1")){
            mc.doSome();
        }
        if (Thread.currentThread().getName().equals("t2")){
            mc.doOther();
        }
    }
}


class MyClass{
    public synchronized void doSome(){
        System.out.println("doSome begin");
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }
    public synchronized void doOther(){
        System.out.println("doSome begin");
        System.out.println("doSome over");
    }
}

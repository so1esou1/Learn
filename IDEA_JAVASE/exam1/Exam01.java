package com.bjpowernode.java.exam1;
/*
面试题：
    doOther执行的时候需不需要等待doSome方法执行的结束？
    不需要！！！！doOther会马上执行
    synchronized出现在实例方法上表示锁this。
    因为doOther()方法上没有synchronized锁，所以执行doOther对象的时候不需要获取共享对象的对象锁
 */
public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        MyClass mc = new MyClass();
        Thread t1 = new MyThread(mc);
        Thread t2 = new MyThread(mc);

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
    public void doOther(){
        System.out.println("doSome begin");
        System.out.println("doSome over");
    }
}

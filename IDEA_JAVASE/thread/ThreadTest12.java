package com.bjpowernode.java.thread;
/*
让位，当前线程暂停，回到就绪状态，让给其他线程
静态方法：Thread.yield();
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable6());
        t.setName("t");
        t.start();

        for (int i = 1;i <= 10000;i ++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
class MyRunnable6 implements Runnable{

    @Override
    public void run() {
        for (int i = 1;i <= 10000;i ++){
            //每100个让位一次
            if (i % 100 == 0){
                Thread.yield();  //当前线程暂停一下，让给主线程
            }
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

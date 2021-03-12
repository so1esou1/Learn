package com.bjpowernode.java2.thread;
/*
    线程创建的第二种方式:实现Runnable接口
    1、创建一个实现Runnable接口的类
    2、实现类去实现Runnable中的抽象方法:run()
    3、创建实现类的对象
    4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
    5、通过Thread类的对象调用start()方法
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        //创建实现类的对象
        MThread mThread = new MThread();
        //将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);    //多态
        //通过Thread类的对象调用start()方法
        t1.setName("线程1");
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        //MThread mThread2 = new MThread();     不用再创建一个类的对象
        //直接在Thread类中新建:
        Thread t2 = new Thread(mThread);        //t1 t2共用同一个模型
        t2.setName("线程2");
        t2.start();
    }
}

//创建一个实现Runnable接口的类
class MThread implements Runnable{
    //实现类去实现Runnable中的抽象方法:run()
    @Override
    public void run() {
        for (int i = 0;i < 100;i ++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

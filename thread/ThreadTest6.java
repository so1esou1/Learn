package com.bjpowernode.java2.thread;
/*
    实现线程同步
    1、问题：卖票过程中出现重票、错票-->出现了线程的安全问题
    2、问题出现原因:当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
    3、怎么解决?加一个锁🔒.当线程A在操作static时，其他线程不能参与进来，直到线程A操作完ticket时，其他线程才能参与进来
这种情况即使线程A出现阻塞也不能改变
    4、在java中，我们通过同步机制解决线程的安全问题
        方式一:同步代码块:
        synchronized(同步监视器){
            需要被同步的代码;
        }
        说明:操作共享数据的代码，即为需要被同步的代码
            共享数据:多数线程共同操作的的变量。如本例中ticket就是共享数据
            同步监视器:俗称锁🔒.任何一个类的对象都可以充当锁
            锁的要求:多个线程必须共有同一把锁

            锁的其他

        方式二:同步方法:
            如果操作共享数据的代码完整地声明在一个方法中，不妨将此方法声明为同步的
            见ThreadTest8

    5、好处:同步的方式，解决了线程的安全问题
        局限性:操作同步代码时只能有一个线程参与，其他线程等待，内部相当于是一个单线程的过程，效率较低
 */
public class ThreadTest6 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Window2 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();  //创建一个对象作为锁
    @Override
    public void run() {
        // Object obj = new Object();obj的声明放在这里不安全，此时每个线程多有属于自己独自的锁
        while (true){
            //synchronized(obj){
            synchronized(this){         //这里的this代表的w1对象，这里是动态获取的，w1是唯一的(这是最方便的对象)
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
                    ticket --;
                }else {
                    break;
                }
            }
        }
    }
}
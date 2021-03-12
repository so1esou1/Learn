package com.bjpowernode.java2.thread;
/*
测试Thread类中的常用方法:
    1、start():启动当前线程，调用当前线程的run()方法
    2、run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
    3、currentThread():静态方法，返回当前线程代码执行的线程
    4、getName():获取当前线程的名字
    5、setName():设置当前线程的名字
    6、yield():线程让步,释放当前cpu的执行权，(也有可能马上又抢到执行权)
    7、join():在线程A中调用线程B的join()方法，此时线程A进入阻塞状态，直到线程B完全执行完以后线程A才结束阻塞状态
    8、sleep(long millitime):
    9、stop():当执行此方法时，强行结束当前线程。已过时，不建议使用
    10、isAlive():判断当前线程是否存活


线程的优先级:
    1、MAX_PRIORITY:10
    2、MIN_PRIORITY:1
    3、NORM_PRIORITY:5 ---默认的优先级
优先级越高，高优先级会抢占低优先级线程cpu的执行权，被cpu执行的几率更高，不是必然更先执行
如何设置当前线程的优先级:
    getPriority():获取当前线程的优先级
    setPriority(int p):设置线程的优先级，要在start之前修改


 */
public class ThreadTest2{
    public static void main(String[] args) {
        HelooThread h1 = new HelooThread();

        //在start之前给线程设置名字，否则就晚了
        h1.setName("线程一");      //也是主线程帮忙设置的名字
        h1.setPriority(8);     //设置优先级为8.设置优先级最好在start方法之前
        h1.start();         //由主线程启动

        //给主线程命名:
        Thread.currentThread().setName("主线程");          //因为这时候是主线程在执行
        for (int i = 0;i < 100;i ++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class HelooThread extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 100;i ++){
            if (i % 2 == 0){
                try {
                    sleep(1000);            //sleep方法必须使用try/catch方法，不能用throws。因为Thread类中的run没有抛异常，所以sleep抛不上去(子类重写的异常不能比父类更大)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 20 == 0){
                this.yield();
            }
        }
    }
}



package com.bjpowernode.java.thread;
/*
sleep睡眠太久了，如何唤醒一个正在睡眠的线程？
    注意：这个不是中断线程的执行
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnalbe2());
        t.setName("t");
        t.start();

        //希望5秒之后，t线程醒来，5秒后主线程手里的活干完了
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终断t线程的睡眠
        t.interrupt();   //干扰，一盆冷水过去，会让29行这个正在睡眠的进程报异常，这种终断方式依靠了异常处理机制
    }
}
class MyRunnalbe2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---> begin");
        try {
            //睡眠一年
            Thread.sleep(1000*60*60*24*365);  //run()方法中的异常不准throws，子类不能比父类抛出更宽泛的异常，父类中没有抛出任何异常
        } catch (InterruptedException e) {
            //打印异常信息
            e.printStackTrace();
        }
        //一年之后才会执行到这里
        System.out.println(Thread.currentThread().getName() + "---> end");//打印异常sleep interrupted后输出"---> end"
        //不想要异常信息可以将e.printStackTrace();注释掉

        //调用doOther
        //doOther();
    }
    //其他方法可以throws
    /*public void doOther() throws Exception{

    }*/
}
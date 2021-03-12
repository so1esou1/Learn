package com.bjpowernode.java2.thread;

import static java.lang.Thread.sleep;

/*
    1、死锁:不同的线程分别占用对方需要的同步资源不放弃。
    都在等待对方放弃自己需要的同步资源，就形成了线程的死锁

    2、说明:出现死锁后，不会出现异常和提示信息，只是所有的线程都处于阻塞状态，无法继续
    我们使用同步时，要避免出现死锁
 */
public class ThreadTest11 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            public void run(){
                synchronized(s1){       //先握s1的锁
                    s1.append("a");
                    s2.append("1");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(s2){     //锁嵌套
                        s1.append("b");
                        s2.append("2");



                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2){       //先握s2的锁
                    s1.append("c");
                    s2.append("3");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(s1){
                        s1.append("d");
                        s2.append("4");



                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

        //会出现死锁现象，程序僵持住
    }
}

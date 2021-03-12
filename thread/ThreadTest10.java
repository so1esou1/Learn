package com.bjpowernode.java2.thread;
/*
    解决单例模式懒汉式的线程安全问题
 */
public class ThreadTest10 {

}


class Bank{
    private Bank(){}

    private static Bank instance = null;        //instance相当于共享数据

    /*public static Bank getInstance(){
        if (instance == null){      //加入第一次进入时在此处发生了阻塞，可能出现两个线程进入，出现线程安全问题
            instance = new Bank();
        }
        return instance;
    }*/

    /*public static synchronized Bank getInstance(){      //这里加上synchronized，变成线程安全
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }*/

    //另一种方法,效率稍差:
    /*public static Bank getInstance(){
        synchronized (Bank.class) {
            if (instance == null){
                instance = new Bank();
            }
            return instance;
        }
    }*/

    //双重检查的方式:
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

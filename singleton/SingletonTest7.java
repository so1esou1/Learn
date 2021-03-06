package com.csu.singleton;
/*
    单例模式7---静态内部类
    分析:
    1、这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
    2、静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化
时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的
实例化。
    3、类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们
保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
    4、优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
    5、结论：推荐使用.
 */
public class SingletonTest7 {
    public static void main(String[] args) {
        System.out.println("单例模式7---静态内部类");
        Singleton7 instance = Singleton7.getInstance();
        Singleton7 instance2 = Singleton7.getInstance();
        System.out.println(instance == instance2);
    }
}

//静态内部类完成，推荐使用
class Singleton7{
    private static volatile Singleton7 instance;

    //构造器私有化
    private Singleton7(){}
    //写一个静态内部类，该类中有一个静态属性
    private static class SingletonInstance{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    //提供一个静态公有方法，直接返回SingletonInstance.INSTANCE
    public static synchronized Singleton7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}


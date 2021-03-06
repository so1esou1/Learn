package com.csu.singleton;
/*
    单例模式懒汉式2:线程安全，同步方法
    分析:解决了线程不安全问题
         效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行
同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，
直接return就行了。方法进行同步效率太低
 */
public class SingletonTest4 {
    public static void main(String[] args) {
        System.out.println("懒汉式2，线程安全，同步方法");
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance == instance2);      //true
    }
}


//懒汉式的第二种实现:线程安全，同步方法
class Singleton4{
    private static Singleton4 instance;

    private Singleton4(){}

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    public static synchronized Singleton4 getInstance(){        //在此处加入synchronized关键字
        //如果instance为空，说明还没有创建，这时候去创建
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
        //这段代码是使用到getInstance时才会创建单例对象

    }
}
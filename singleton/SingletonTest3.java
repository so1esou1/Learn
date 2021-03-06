package com.csu.singleton;
/*
    单例模式：懒汉式---常规版(线程不安全)
    分析:
    起到了Lazy Loading的效果，但是只能在单线程下使用.
    如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及
往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以
在多线程环境下不可使用这种方式
    结论：在实际开发中，不要使用这种方式.
 */
public class SingletonTest3 {
    public static void main(String[] args) {
        System.out.println("懒汉式1，线程不安全");
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance == instance2);      //true
    }
}

class Singleton3{
    private static Singleton3 instance;

    private Singleton3(){}

    //提供一个静态的公有方法，当使用该方法时，才去创建instance
    //即懒汉式
    public static Singleton3 getInstance(){
        //如果instance为空，说明还没有创建，这时候去创建
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
        //这段代码是使用到getInstance时才会创建单例对象

    }
}


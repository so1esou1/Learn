package com.csu.singleton;
/*
    单例模式:
    饿汉式1--静态常量

    评价:优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同
步问题
        缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始
至终从未使用过这个实例，则会造成内存的浪费
    这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载
时就实例化，在单例模式中大多数都是调用getInstance方法， 但是导致类装载
的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类
装载，这时候初始化instance就没有达到lazy loading的效果
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        //测试:
        //不能直接new
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        //再次拿这个实例，会发现这两个实例是相同的
        System.out.println(instance == instance2);      //true
    }
}



class Singleton{
    //1、构造器私有化，外部不能new
    private Singleton(){

    }

    //2、在本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3、返回一个公有的静态方法，返回实例对象即可
    public static Singleton getInstance(){
        return instance;
    }
}

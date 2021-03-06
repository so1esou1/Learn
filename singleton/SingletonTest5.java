package com.csu.singleton;
/*
    单例模式懒汉模式3---线程安全，同步代码块
    分析:
    (1)这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，
改为同步产生实例化的的代码块
    (2)但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一
致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
另一个线程也通过了这个判断语句，这时便会产生多个实例

    (3)结论：在实际开发中，不能使用这种方式,这种方式是不对的
 */
public class SingletonTest5 {
    public static void main(String[] args) {
        System.out.println("懒汉式3,线程安全，同步代码块");
        Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance == instance2);          //true
    }
}

class Singleton5{
    private static Singleton5 singleton;
    private Singleton5(){}
    public static Singleton5 getInstance(){
        if (singleton == null){
            synchronized (Singleton5.class){
                singleton = new Singleton5();
            }
        }
        return singleton;
    }
}



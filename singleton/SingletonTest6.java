package com.csu.singleton;
/*
    单例模式 双重检测
    分析:
    (1)多线程开发中常使用到的,进行了两次if (singleton == null)检查，这样就可以保证线程安全了
    (2)实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
直接return实例化对象，也避免的反复进行方法同步
    (3)线程安全；延迟加载；效率较高
    (4)结论：在实际开发中，推荐使用这种单例设计模式
 */
public class SingletonTest6 {
    public static void main(String[] args) {
        System.out.println("双重检测");
        Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance2 = Singleton6.getInstance();
        System.out.println(instance == instance2);
    }
}


class Singleton6{
    private static volatile Singleton6 instance;      //volatile必须写上，作用是保证可见性，禁止指令重排
    private Singleton6(){}
    //加入双重检查代码，解决线程安全问题，同时解决懒加载的问题，同时保证了效率，推荐使用
    public static Singleton6 getInstance(){
        if (instance == null){              //多线程在这段就被拦住了，不会浪费多的资源，一次只能有一个线程进入
            synchronized (Singleton6.class){
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }

        return instance;
    }
}

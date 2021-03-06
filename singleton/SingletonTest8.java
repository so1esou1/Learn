package com.csu.singleton;
/*
    单例模式8---枚举型
    分析:
    枚举来实现单例模式。不仅能避免多线程同步问题，而
且还能防止反序列化重新创建新的对象。
    结论：推荐使用
 */
public class SingletonTest8 {
    public static void main(String[] args) {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance1 == instance2);     //true
    }
}

//使用枚举可以实现单例，推荐使用
enum SingletonEnum{
    INSTANCE;       //属性
    public void sayOK(){
        System.out.println("ok");
    }
}
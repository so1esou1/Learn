package com.csu.facade;
//爆米花类
public class Popcorn {
    //饿汉式
    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("popcorn on");
    }

    public void off(){
        System.out.println("popcorn off");
    }

    public void pop(){
        System.out.println("popcorn is poping");
    }
}

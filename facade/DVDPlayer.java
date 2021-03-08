package com.csu.facade;
//dvd类
public class DVDPlayer {
    //使用单例模式(饿汉式)
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("DVD打开了");
    }
    public void off(){
        System.out.println("DVD关闭了");
    }
    public void play(){
        System.out.println("DVD正在播放中");
    }
    public void pause(){
        System.out.println("DVD暂停....");
    }
}

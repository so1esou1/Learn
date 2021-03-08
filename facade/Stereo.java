package com.csu.facade;
//立体声类
public class Stereo {
    //饿汉式
    private static Stereo instance = new Stereo();

    public static Stereo getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("Stereo on");
    }

    public void off(){
        System.out.println("Stereo off");
    }

    public void up(){
        System.out.println("Stereo up");
    }
}

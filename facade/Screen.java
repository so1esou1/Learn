package com.csu.facade;
//屏幕类
public class Screen {
    //饿汉式
    private static Screen instance = new Screen();

    public static Screen getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("Screen up");
    }

    public void down(){
        System.out.println("Screen down");
    }
}

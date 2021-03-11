package com.csu.strategy;
//野鸭类
public class WildDuck extends Duck{
    //构造器,传入FlyBehavior的对象:
    public WildDuck() {
        flyBehavior = new GoodBehavior();       //认为野鸭的飞行技术好
    }

    @Override
    public void display() {
        System.out.println("这时野鸭");
    }
}

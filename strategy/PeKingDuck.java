package com.csu.strategy;
//北京鸭类
public class PeKingDuck extends Duck{
    //构造器
    public PeKingDuck(){
        flyBehavior = new NoFlyBehavior();      //认为北京鸭不能飞行
    }


    @Override
    public void display() {
        System.out.println("这是北京鸭");
    }
}

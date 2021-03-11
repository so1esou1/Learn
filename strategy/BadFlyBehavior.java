package com.csu.strategy;
/*
    不擅长飞翔的类
 */
public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("不擅长飞行");
    }
}

package com.csu.strategy;
/*
    不能飞翔的类
 */
public class NoFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("不能飞行");
    }
}

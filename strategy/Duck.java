package com.csu.strategy;
/*
    鸭子类
    有飞行的属性
 */
public abstract class Duck {
    //属性，聚合策略接口
    FlyBehavior flyBehavior;

    public Duck() {
    }
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();//显示鸭子信息

    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }

    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    public void fly() {
        //改进
        if (flyBehavior != null){
            flyBehavior.fly();
        }
    }
}

package com.csu.strategy;
//玩具鸭类
public class ToyDuck extends Duck{
    public ToyDuck(){
        flyBehavior = new NoFlyBehavior();
    }


    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }
}

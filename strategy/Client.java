package com.csu.strategy;

public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        //更改北京鸭的飞行状态
        PeKingDuck peKingDuck = new PeKingDuck();
        peKingDuck.setFlyBehavior(new GoodBehavior());      //改成擅长飞行
    }
}

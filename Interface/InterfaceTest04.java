package com.csu.javase.Interface;

import java.io.Flushable;

/*
11、继承和实现都存在的话，extends关键字在前，implements关键字在后
 */
public class InterfacecTest04 {
    public static void main(String[] args) {
        Flyable f = new Cat();//多态
        f.fly();
        Flyable f2 = new Pig();
        f2.fly();
        //同一个接口，调用同一个方法，最好执行效果不同
    }
}
class Animal{

}
//可飞行的接口
interface Flyable{
    void fly();
}
class Cat extends Animal implements Flyable{
    @Override
    public void fly() {
        System.out.println("猫飞");
    }
}
class Pig extends Animal implements Flyable{
    @Override
    public void fly() {
        System.out.println("飞猪");
    }
}
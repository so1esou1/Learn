package com.csu.adapter.classadapter;

public class Client {
    public static void main(String[] args) {
        System.out.println("类适配器模式");
        //首先创建一个手机
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}

package com.csu.adapter.objectadapter;


public class Client {
    public static void main(String[] args) {
        System.out.println("对象适配器模式");
        //首先创建一个手机
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));      //创建一个Voltage220V的对象
    }
}

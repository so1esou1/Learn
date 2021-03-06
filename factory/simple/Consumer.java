package com.csu.factory.simple;

public class Consumer {
    public static void main(String[] args) {
        /*原来方式:创建对象
        Car wuling = new WuLing();
        Tesla tesla = new Tesla();
         */
        //使用工厂创建:
        Car wuling = CarFactory.getCar("五菱");
        Car tesla = CarFactory.getCar("特斯拉");
        wuling.name();
        tesla.name();
    }
}

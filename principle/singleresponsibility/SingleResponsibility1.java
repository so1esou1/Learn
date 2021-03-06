package com.csu.principle.singleresponsibility;
/*
    单一职责原则
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("飞机");
        vehicle.run("汽车");
        /*
        摩托车在公路上运行
        飞机在公路上运行
        汽车在公路上运行
         */
    }
}

//交通工具类
//方式1：
//1、在方式1中的run方法中，违反了单一职责原则
//2、解决的方案:根据交通工具运行的方式不同即可
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行");
    }
}

package com.csu.principle.singleresponsibility;
/*
    方案3：分析：
    1、这种修改方法没有对原来的类进行大的修改，只是增加了方法
    2、在一定程度上没有完全遵守单一职责原则，但是在方法级别上仍然遵守单一职责
    3、

 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("汽车");
        vehicle2.runWater("轮船");
        vehicle2.runAir("飞机");
    }
}

class Vehicle2{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行....");
    }

    public void runAir(String vehicle){
        System.out.println(vehicle + "在天空上运行....");
    }

    public void runWater(String vehicle){
        System.out.println(vehicle + "在水中运行....");
    }
}

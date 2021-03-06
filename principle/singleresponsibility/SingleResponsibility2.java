package com.csu.principle.singleresponsibility;
/*
    方案二的分析：1、首先遵循了单一职责原则
                 2、但是这样的改动很大，将类分解，需要修改客户端
                 3、改进:直接修改Vehicle类，改动的代码会比较少 => 方案3
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehricle = new RoadVehicle();
        roadVehricle.run("摩托车");
        roadVehricle.run("飞机");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("汽车");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
    }
}


class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行");
    }
}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在天空上运行");
    }
}

class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在水中上运行");
    }
}
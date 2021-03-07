package com.csu.adapter.classadapter;

public class Phone {
    //充电的方法:
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5){
            System.out.println("电压为5伏，可以充电");
        }else if (iVoltage5V.output5V() > 5){
            System.out.println("电压过高，无法充电");
        }
    }
}

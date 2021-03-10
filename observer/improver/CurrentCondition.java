package com.csu.observer.improver;
/*
    显示当前温度情况，可以理解成是当前气象站自己的网站,跟原先写的一样
    要实现Observer接口
 */
public class CurrentCondition implements Observers{
    private float temperature;  //温度
    private float pressure;     //气压
    private float humidity;     //湿度
    public void update(float temperature,float pressure,float humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();}
    public void display(){
        System.out.println("***Today mTemperature: "+temperature+"***");
        System.out.println("***Today mPressure: "+pressure+"***");
        System.out.println("***Today mHumidity: "+humidity+"***");
    }
}

package com.csu.observer.improver;
/*
    百度接入
 */
public class Baidu implements Observers{
    private float temperature;  //温度
    private float pressure;     //气压
    private float humidity;     //湿度
    public void update(float temperature,float pressure,float humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();}
    public void display(){
        System.out.println("***Today baidu: "+temperature+"***");
        System.out.println("***Today baidu: "+pressure+"***");
        System.out.println("***Today baidu: "+humidity+"***");
    }
}

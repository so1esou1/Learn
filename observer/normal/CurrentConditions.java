package com.csu.observer.normal;
/*
    显示当前温度情况，可以理解成是当前气象站自己的网站
    使用的是推送模式
 */
public class CurrentConditions {
    private float temperature;  //温度
    private float pressure;     //气压
    private float humidity;     //湿度
    public void update(float temperature,float pressure,float humidity){   //更新，WeatherData 调用
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();}
    public void display(){      //显示
        System.out.println("***Today mTemperature: "+temperature+"***");
        System.out.println("***Today mPressure: "+pressure+"***");
        System.out.println("***Today mHumidity: "+humidity+"***");
    }
}

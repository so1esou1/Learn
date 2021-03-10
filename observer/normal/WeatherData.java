package com.csu.observer.normal;
/*
    核心类，包含最新的天气情况信息
    含有CurrentConditions对象
    当数据有更新时，就主动调用CurrentConditions对象的update方法（含有display），这样接入方就看到了最新的信息
 */
public class WeatherData {
    private float temperatrue;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;
    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions; }

    public float getTemperature() {
        return temperatrue;
    }
    public float getPressure() {
        return pressure;
    }
    public float getHumidity() {
        return humidity;
    }
    public void dataChange() {
        //调用接入方的update方法
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }
    //当数据有更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //将最新的信息推送给接入方
        dataChange();
    }
}

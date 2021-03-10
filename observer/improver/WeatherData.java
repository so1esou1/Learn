package com.csu.observer.improver;

import com.csu.observer.normal.CurrentConditions;

import java.util.ArrayList;

/*
    ,最核心的类，天气的信息、管理观察者Observer
    含有观察者集合，使用ArrayList管理，当数据有变化时，通知接入方，让她们看到最新的消息
 */
public class WeatherData implements Subject{
    private float temperatrue;
    private float pressure;
    private float humidity;
    //现在是观察者集合,对以下进行修改:
    //private CurrentConditions currentConditions;
    private ArrayList<Observers> observers;

    public WeatherData() {
        observers = new ArrayList<Observers>();
    }

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
        //currentConditions.update(getTemperature(), getPressure(), getHumidity());
        //要通知所有第三方:
        notifyObservers();
    }
    //当数据有更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //将最新的信息推送给接入方
        dataChange();
    }




    @Override
    public void registerObserver(Observers o) {
        observers.add(o);       //注册一个观察者
    }

    @Override
    public void removeObserver(Observers o) {
        if (observers.contains(o)){
            observers.remove(o);        //移除一个观察者
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0;i < observers.size();i ++){      //遍历所有观察者并通知
            observers.get(i).update(getTemperature(),this.pressure,getHumidity());
        }
    }
}

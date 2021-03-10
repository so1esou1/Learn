package com.csu.observer.improver;

public class Client {
    public static void main(String[] args) {
        //创建一个WeatherData
        WeatherData weatherData = new WeatherData();
        //创建观察者:
        CurrentCondition currentConditions = new CurrentCondition();
        Baidu baidu = new Baidu();
        //注册到weatherData
        weatherData.registerObserver(currentConditions);

        //移除百度:
        weatherData.removeObserver(baidu);
        //测试:
        System.out.println("通知各个注册的观察者,看看信息");
        weatherData.setData(10f,10f,30f);

    }
}

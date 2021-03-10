package com.csu.observer.normal;
/*
    传统方案的问题:
        1) 其他第三方接入气象站获取数据的问题
        2) 无法在运行时动态的添加第三方 (新浪网站)
        3) 违反ocp原则=>观察者模式
    在WeatherData中，当增加一个第三方，都需要创建一个对应的第三方的公告板
    对象，并加入到dataChange, 不利于维护，也不是动态加入
 */
public class Client {
    public static void main(String[] args) {
        //创建一个接入方:
        CurrentConditions currentConditions = new CurrentConditions();
        //创建weatherData对象，并将接入方传递到weatherData中
        WeatherData weatherData = new WeatherData(currentConditions);
        //更新天气情况
        weatherData.setData(30, 150, 40);

        //天气情况变化了
        System.out.println("天气情况发生了变化");
        weatherData.setData(28, 160, 35);
    }
}

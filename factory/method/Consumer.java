package com.csu.factory.method;
/*
    给每种汽车增加一个生产工厂，这个车的工厂要去实现总的工厂接口
 */
public class Consumer {
    public static void main(String[] args) {
        Car car1 = new WulingFactory().getCar();        //创建五菱车
        Car car2 = new TeslaFactory().getCar();         //创建特斯拉车
        car1.name();
        car2.name();

        Car car3 = new MobaiFactory().getCar();
        car3.name();
    }
    //从结构复杂度、代码复杂度、客户端编程复杂度、管理复杂度来说，简单工厂更好
    //根据设计原则，工厂设计模式不会扰乱程序设计,扩展力更强
    //但是实际业务中，大多数还是选择简单工厂模式!
}

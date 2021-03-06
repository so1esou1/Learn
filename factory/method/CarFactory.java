package com.csu.factory.method;
/*
    工厂方法模式:
    需要创建多个工厂，但可以实现横向的扩展.我们需要新创建一个产品的话，只需要创建一个这种产品的工厂，然后实现CarFactory接口就行
 */
public interface CarFactory {
    Car getCar();
}

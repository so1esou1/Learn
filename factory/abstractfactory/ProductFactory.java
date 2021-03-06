package com.csu.factory.abstractfactory;
/*
    创建工厂的总工厂，抽象产品工厂，生产手机、路由器
 */
public interface ProductFactory {

    //生产手机
    PhoneProduct phoneProduct();
    //生产路由器
    RounterProduct rounterProduct();
}

package com.csu.factory.abstractfactory;
/*
    路由器产品接口
 */
public interface RounterProduct {
    void start();
    void shutdown();
    void openWifi();
    void setting();
}

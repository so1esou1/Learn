package com.csu.factory.abstractfactory;
/*
    客户购买，客户端
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("小米系的产品:========================================");
        //创建一个小米工厂
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();

        //通过小米工厂生产手机和路由器
        PhoneProduct xmpp = xiaoMiFactory.phoneProduct();
        xmpp.callup();
        xmpp.sendSMS();
        RounterProduct xmr = xiaoMiFactory.rounterProduct();
        xmr.openWifi();
        xmr.start();

        System.out.println("华为系的产品:========================================");
        //创建一个华为工厂
        HuaweiFactory huaweiFactory = new HuaweiFactory();

        //通过华为工厂生产手机和路由器
        PhoneProduct hwpp = huaweiFactory.phoneProduct();
        hwpp.callup();
        hwpp.sendSMS();
        RounterProduct hwr = huaweiFactory.rounterProduct();
        hwr.start();
        hwr.openWifi();
    }
}

package com.csu.factory.abstractfactory;
/*
    小米的工厂
 */
public class XiaoMiFactory implements ProductFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public RounterProduct rounterProduct() {
        return new XiaoMiRounter();
    }
}

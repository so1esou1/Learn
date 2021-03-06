package com.csu.factory.abstractfactory;
/*
    华为的工厂
 */
public class HuaweiFactory implements ProductFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RounterProduct rounterProduct() {
        return new HuaweiRouter();
    }
}

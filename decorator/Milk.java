package com.csu.decorator;
//具体的调味品
public class Milk extends Decorator{
    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }
}

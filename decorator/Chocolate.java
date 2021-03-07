package com.csu.decorator;
//具体的调味品
public class Chocolate extends Decorator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f);
    }

}

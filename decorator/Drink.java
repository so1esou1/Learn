package com.csu.decorator;
//抽象的Drink类
public abstract class Drink {
    public String des;      //描述
    private float price = 0.0f;

    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    //计算价格的抽象方法
    //会被子类实现
    public abstract float cost();
}

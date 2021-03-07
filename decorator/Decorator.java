package com.csu.decorator;
//装饰者，抽象的调味品
public class Decorator extends Drink{
    private Drink obj;      //调料
    //构造器
    public Decorator(Drink obj){        //组合的关系
        this.obj = obj;
    }
    @Override
    public float cost() {
        //super.getPrice()拿到咖啡的价格
        return super.getPrice() + obj.cost();
    }

    public String getDes(){
        //obj.getDes()  输出了被装饰者Drink的信息
        return super.des + " " + super.getPrice() + " && " + obj.getDes();
    }
}

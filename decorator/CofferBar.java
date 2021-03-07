package com.csu.decorator;
//客户端，调用者
public class CofferBar {
    public static void main(String[] args) {
        //使用装饰者下订单:2份巧克力+1份牛奶的美式咖啡

        //1、先点一份美式咖啡
        Drink order = new MeishiCoffer();        //这里最好用Drink接收，因为还有调料品要加入
        System.out.println("费用1=" + order.cost());      //5.0
        System.out.println("描述1=" + order.getDes());

        //加入一份牛奶
        order  = new Milk(order);
        System.out.println(order.cost());       //7.0
        //加入一份巧克力:
        order = new Chocolate(order);
        System.out.println(order.cost());       //10.0
        //最后再加一分巧克力:
        order = new Chocolate(order);
        System.out.println(order.cost());       //13.0
    }
}

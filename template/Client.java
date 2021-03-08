package com.csu.template;

public class Client {
    public static void main(String[] args) {
        //制作红豆豆浆
        System.out.println("制作红豆豆浆");
        SoyMilk redBeanSoyMilk = new RedBeanSoyMilk();      //抽象类接收
        redBeanSoyMilk.make();

        System.out.println("制作花生豆浆");
        SoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}

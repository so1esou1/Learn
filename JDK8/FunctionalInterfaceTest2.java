package com.bjpowernode.java2.JDK8;

import java.util.function.Consumer;

public class FunctionalInterfaceTest2 {
    public static void main(String[] args) {
        FunctionalInterfaceTest2 f = new FunctionalInterfaceTest2();
        f.happy(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });

        //使用lambda表达式的写法:
        f.happy(400,money -> System.out.println(money));

    }

    public void happy(double money, Consumer<Double> com){
        com.accept(money);
    }
}

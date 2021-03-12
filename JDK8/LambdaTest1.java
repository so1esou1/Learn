package com.bjpowernode.java2.JDK8;
/*
    lambda表达式使用举例
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        //提供一个实现Runnable接口的匿名实现类对象:
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("一三一四");
            }
        };
        r1.run();


        System.out.println("=============================");
        System.out.println("使用lambda表达式进行重写:");
        //-> 叫lambda操作符
        Runnable r2 = () -> System.out.println("一三一四");
        r2.run();

    }


}

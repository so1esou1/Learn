package com.csu.juc;

import java.util.function.Consumer;

/*
    消费型接口,只有输入，没有返回值
 */
public class JUCTest26Consumer1 {
    public static void main(String[] args) {
        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };*/


        //lambda表达式:
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("asdaddasd");
    }
}

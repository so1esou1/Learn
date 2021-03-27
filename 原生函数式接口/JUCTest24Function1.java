package com.csu.juc;

import java.util.function.Function;

/*
    函数式接口示例function
 */
public class JUCTest24Function1 {
    public static void main(String[] args) {
        /*Function function = new Function<String,String>() {     //泛型内表示的是下面方法传入的参数和返回的类型
            @Override
            public String apply(String str) {
                return str;
            }
        };*/

        //只要是函数式接口都可以使用lambda表达式简化:
        Function function = (str)->{return str;};

        //调用函数:
        System.out.println(function.apply("abc"));
    }
}

package com.csu.juc;

import java.util.function.Predicate;

/*
    断定式接口predicate,有一个输入参数，返回值必须是布尔值
 */
public class JUCTest25Predicate1 {
    public static void main(String[] args) {
        //要求:判断字符串是否为空
        /*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };*/


        //使用lambda表达式简化:
        Predicate<String> predicate = (str)->{return str.isEmpty();};

        System.out.println(predicate.test(""));
    }
}

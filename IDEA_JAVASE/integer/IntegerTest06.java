package com.bjpowernode.javase.integer;
/*
分析以下程序*****
这个题目是Integer非常重要的面试题！！！！！
 */
public class IntegerTest06 {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);//false

        /*
        java中为了提高程序的执行效率，将-128至127间所有包装对象提前创建好，放在一个“整数型常量池”当中了
        目的是，只要用这个区间的数据，不需要再new新对象了，直接从整数型常量池当中取出来。
        Integer在使用时会初始化整数型常量池中256个对象
        池其实就是缓存cache，缓存优点是效率高，缺点是占用内存空间，大型项目中的重要优化手段就是cache缓存机制
         */

        Integer x = 127;
        Integer y = 127;
        //双等号永远判断的都是两个对象的内存地址是否相同。
        System.out.println(x == y);//true，原理是x变量中保存内存地址和y保存的是一样的
    }
}

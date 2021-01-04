package com.bjpowernode.javase.integer;
/*
在JDK1.5之后，支持自动装箱和自动拆箱了
    自动装箱：基本数据类型自动转换成包装类
    自动拆箱：包装类自动转换为基本数据类型

    有了自动拆箱之后，Number类中的方法就用不着了！
    自动拆箱、装箱好处：方便编程
 */
public class IntegerTest05 {
    public static void main(String[] args) {
        //自动装箱（基本数据类型-->包装类 ）
        //900是基本数据类型，x是包装类型
        Integer x = 900;
        System.out.println(x);//900

        //自动拆箱（包装类-->基本数据类型）
        //x是包装类型，y是基本数据类型
        int y = x;
        System.out.println(y);//900

        //z还是保存的内存地址
        Integer z = 1000;//等同于Integer z = new Integer(1000);
        //+只能算基本数据类型的数字，为什么下面没有报错呢？
        System.out.println(z + 1);//运算符在使用时会将z进行自动拆箱，转换成基本数字类型
        //在java5之前这么写肯定编译器报错

        Integer a = 1000;//Integer a = new Integer(1000);a是个引用，保存内存地址指向对象
        Integer b = 1000;//Integer b = new Integer(1000);b是个引用，保存内存地址指向对象
        System.out.println(a == b);//false，两个内存地址不一样
        //**只有运算时才会自动拆箱
    }
}

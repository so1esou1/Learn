package com.bjpowernode.javase.string;
/*
关于java JDK中内置的一个类：java.lang.String
   1、String表示字符串类型，属于引用数据类型，不属于基本数据类型
   2、java中随便用双引号括起来的都是String对象
   3、java中规定，双引号括起来的字符串是不可变的，也就是说"abc"自出生到最终死亡，不可变（java中的特色）
   4、JDK中双引号括起来的字符串都是直接存储在“方法区”的“字符串常量池”当中的
      为什么SUN公司把字符串存储在一个“字符串常量池”当中？   因为字符串在实际开发中使用太频繁，为了执行效率，所以放到了“方法区”的“字符串常量池”当中
 */
public class StringTest01 {
    public static void main(String[] args) {
        //这两行代码表示底层创建了3个字符串对象，都在字符串常量池中。详情见画图
        String s1 = "abcdef";
        String s2 = "abcdef" + "xy";

        //这是使用new的方式创建的字符串对象，。这个代码中的"xy"是从哪里来的？
        //凡是双引号括起来的都在字符串常量池中有一份。new对象的时候一定在堆内存中开辟空间
        String s3 = new String("xy");
    }
}

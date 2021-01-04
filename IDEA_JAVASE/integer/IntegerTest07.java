package com.bjpowernode.javase.integer;
/*
Integer类当中有哪些常用的方法呢？
 */
public class IntegerTest07 {
    public static void main(String[] args) {
        //手动装箱
        Integer x = new Integer(1000);
        //1、手动拆箱
        int y = x.intValue();
        System.out.println(y);

        //Integer a = new Integer("123");编译通过
        //编译的时候没问题，符合java语法，运行时会不会出问题呢？
        //不是一个“数字”，可以包装成Integer吗？   不能，运行时出现异常
        //Integer a = new Integer("中文");
        //著名异常**：NumberFormatException
        //自动装箱要求至少要是数字才行

        //2、重点方法
        //static int parseInt(String s)
        //静态方法，传参String,返回int
        int retValue = Integer.parseInt("123");  //String -转换-> int
        System.out.println(retValue + 100);//223
        //网页上文本框中输入的100实际上是“100”字符串
        //后台数据库中要求存储100数字，此时java程序需要将“100”转换成100数字

        //照葫芦画瓢
        double retValue2 = Double.parseDouble("3.14");
        System.out.println(retValue2 + 1);//4.140000000000001(精度问题)

        //照葫芦画瓢
        float retValue3 = Float.parseFloat("1.0");
        System.out.println(retValue3);//1.0

        //-----------------------------了解内容，不需掌握------------------------------
        //static String toBinaryString(int i)
        //静态的：将10进制转换为2进制
        String binaryString = Integer.toBinaryString(3);
        System.out.println(binaryString);//11

        //static String toHexString(int i)
        //静态的：将10进制转换为16进制的字符串
        String hexString = Integer.toHexString(16);
        System.out.println(hexString);//"10"

        //static String toOctalString(int i)
        //静态的：将10进制转换为8进制的字符串
        String octalString = Integer.toOctalString(8);
        System.out.println(octalString);//10

        //（了解）valueOf方法
        //static Integer valueOf(int i)
        //静态的：int-->Integer
        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        //static Integer valueOf(static s)
        //静态的：String-->Integer
        Integer i2 =Integer.valueOf("100");
        System.out.println(i2);
    }
}

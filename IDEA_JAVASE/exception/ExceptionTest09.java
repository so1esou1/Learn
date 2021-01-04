package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
异常对象的两个方法：
    String msg = exception getMessage()；
    exception.printStackTrace()；

我们以后查看异常的信息的追踪信息，我们应该怎么看，可以快速地调试程序呢？
    控制台中，从上往下一行一行看，但是需要注意的是，SUN公司写的代码不需要看，只看自己编写的代码上
 */
public class ExceptionTest09 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
            //打印异常堆栈追踪信息
            //实际开发中建议使用这个，养成好习惯！！！
            e.printStackTrace();//这行代码不写的话，程序除了问题也不知道
            /*
            java.io.FileNotFoundException: E:\Game\Config\Champions\Kayn (拒绝访问。)
                at java.base/java.io.FileInputStream.open0(Native Method)
                at java.base/java.io.FileInputStream.open(FileInputStream.java:211)
                at java.base/java.io.FileInputStream.<init>(FileInputStream.java:153)
                at java.base/java.io.FileInputStream.<init>(FileInputStream.java:108)
                at com.bjpowernode.javase.exception.ExceptionTest09.m3(ExceptionTest09.java:28)
                at com.bjpowernode.javase.exception.ExceptionTest09.m2(ExceptionTest09.java:25)
                at com.bjpowernode.javase.exception.ExceptionTest09.m1(ExceptionTest09.java:22)
                at com.bjpowernode.javase.exception.ExceptionTest09.main(ExceptionTest09.java:14)
                //因为28行出问题导致25行
                //25行出问题导致22行
                //22......14行
                //应该先查看28行代码，28行是代码错误的根源
             */
        }
        //这里程序不耽误执行，很健壮（服务器不会因为遇到异常而宕机）
        System.out.println("hello world");//hello world
    }
    private static void m1() throws FileNotFoundException {
        m2();
    }
    private static void m2() throws FileNotFoundException {
        m3();
    }
    private static void m3() throws FileNotFoundException {
        new FileInputStream("E:\\Game\\Config\\Champions\\Kayn");
    }
}

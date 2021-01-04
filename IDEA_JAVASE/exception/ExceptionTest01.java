package com.bjpowernode.javase.exception;
/*
1、什么是异常？异常机制有什么用？
    以下程序执行过程中发生了不正常的情况，这种不正常的情况叫做异常
    java语言是很完善的，提供了异常的处理方式，以下程序出现不正常情况
    java把该异常信息打印输出到控制台，供程序员参考，程序员看到异常信息后可以修改，让程序更加健壮

 */
public class ExceptionTest01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c = a/ b;//实际上，JVM在执行到此处时会new一个异常对象：ArithmeticException（"/ by zero"）;
        System.out.println(a + "/" + b + "=" + c); //异常信息，JVM打印：java.lang.ArithmeticException: / by zero
    }
}

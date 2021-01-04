package com.bjpowernode.javase.exception;
/*
java语言中异常信息是以什么样的形式存在的呢？
    1、在java中以类的形式存在，每个异常类都可以创建异常对象
 */
public class ExceptionTest02 {
    public static void main(String[] args) {
        //通过“异常类”实例化“异常对象”
        NumberFormatException nfe = new NumberFormatException("数字格式化异常");
        System.out.println(nfe);  //java.lang.NumberFormatException: 数字格式化异常

        //通过异常类创建异常对象
        NullPointerException npe = new NullPointerException("空指针异常发生了");
        System.out.println(npe);//java.lang.NullPointerException: 空指针异常发生了
    }
}

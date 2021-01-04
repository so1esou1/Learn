package com.bjpowernode.javase.exception;
/*
异常对象有两个非常重要的方法：
   1、 String msg = exception getMessage();获取异常简单的描述信息
   2、 exception.printStackTrace();打印异常追踪的堆栈信息
 */
public class ExceptionTest08 {
    public static void main(String[] args) {
        NullPointerException e = new NullPointerException("空指针异常");
        //获取异常简单描述信息，这个信息实际上就是构造方法上面String参数
        String msg = e.getMessage();
        System.out.println(msg);//空指针异常

        //打印异常堆栈信息
        //java后台打印异常堆栈追踪信息的时候，采用了异步线程的方式打印的
        e.printStackTrace();
        System.out.println("hello world!");//hello world!
                                           // java.lang.NullPointerException: 空指针异常
    }
}

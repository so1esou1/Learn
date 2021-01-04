package com.bjpowernode.javase.exception;
/*
面试中常见的笔试题：
    final、finally、finalize有什么区别？

 */
public class ExceptionTest14 {
    public static void main(String[] args) {
        //1、final是一个关键字，修饰变量表示最终得不变的
        final int i = 100;

        //2、finally也是一个关键字，和 try联合使用在异常处理机制中，在finally语句块中的代码是一定会执行得
        try{

        }finally {
            System.out.println("finally...");
        }

        //3、finalize是Object类中的一个方法，作为方法名出现，是一个标识符
    }
}

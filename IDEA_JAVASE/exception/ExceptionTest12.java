package com.bjpowernode.javase.exception;

public class ExceptionTest12 {
    public static void main(String[] args) {
        try{
            System.out.println("try...");
            //退出JVM
            System.exit(0);
        }finally {
            System.out.println("finally...");//执行不了，只有System.exit(0);这个代码可以终止finally
        }
    }
}

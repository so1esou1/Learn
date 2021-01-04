package com.bjpowernode.javase.exception;
/*
finally语句
 */
public class ExceptionTest11 {
    public static void main(String[] args) {
        /*
        try和finally，没有catch语句可以吗？
            try不可以单独使用，try和finally可以联合使用
        以下代码执行顺序：
            先执行try……
            再执行finally……
            最后执行return（return语句只要执行，方法必然结束）
         */
        try{
            System.out.println("try...");
            return;
        }finally {
            System.out.println("finally...");
        }
        //这里不能写语句，因为这个代码是无法执行到的
        //System.out.println("helloworld");
    }
}

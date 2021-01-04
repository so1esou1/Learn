package com.bjpowernode.javase.exception;

public class ExceptionTest05 {
    //第一种处理方式：在方法声明位置上继续使用throws来完成异常的继续上抛，抛给调用者（推卸责任）
    /*public static void main(String[] args) throws ClassNotFoundException {
        doSome();
    }*/

    //第二种处理方式：try...catch进行捕捉(将异常拦下，真正解决，调用者不知道)
    public static void main(String[] args) {
        try {
            doSome();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome!!!!");
    }
}

package com.bjpowernode.javase.exception;
/*
以下代码报错的原因：
    因为doSome()方法声明位置上使用了：throws ClassNotFoundException
    而ClassNotFoundException时编译时异常，必须处理，没有处理编译器报错
 */
public class ExceptionTest04 {
    public static void main(String[] args) {
        //在main方法中调用doSome()方法
        //因为doSome()方法声明位置上有throws ClassNotFoundException
        //我们在调用doSome()方法的时候必须对这个异常进行预先的处理，如果不处理，编译器就会出错
        //doSome();

    }

    /**
     * doSome方法在方法声明的位置上使用了：throws ClassNotFoundException
     * 这个代码表示doSome()在执行过程中，有可能会出现ClassNotFoundException异常
     * 叫做类没有找到异常。这个异常直接父类时Exception，所以ClassNotFoundException属于编译时异常
     * @throws ClassCastException
     */
    public void doSome() throws ClassNotFoundException{
        System.out.println("doSome!!!!");
    }
}

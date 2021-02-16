package com.csu.javase.Final;
//final修饰的方法无法被覆盖、被重写
//final控制不了能不能调用的问题
public class FinalTest02 {
}
class C{
    public final void doSome(){
        System.out.println("dosome");
    }
}
class D extends C{
    /*public void doSome(){
        System.out.println("doother");
    }*/
}

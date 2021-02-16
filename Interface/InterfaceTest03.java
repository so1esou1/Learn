package com.csu.javase.Interface;

//9、类可以继承多个接口,需要把每个接口中的方法全都重写，这种机制弥补了java中的类和类中的单继承缺陷

//10、实际上单继承是为了简单而定义的，现实世界中是有多继承的
public class InterfaceTest03 {
    public static void main(String[] args) {
        //多态怎么写
        D d = new G();
        E e = new G();
        F f = new G();

        //接口和接口之间进行强制类型转换的时候，没有继承关系，也可以强制转换,编译时能通过，但是运行时会报错classcastException异常
        /*D d1 = (D)E;
        d1.m1();*/

    }
}

interface D{
    void m1();
}
interface E{
    void m2();
}
interface F{
    void m3();
}

class G implements D,E,F{
    //类可以继承多个接口,需要把每个接口中的方法全都重写
    @Override
    public void m1() {
    }
    @Override
    public void m2() {
    }
    @Override
    public void m3() {
    }

}

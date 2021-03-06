package com.csu.principle.liskov;
/*
    里氏替换原则--错误示范
 */
public class Liskov1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");

        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3));   //这里程序员的本意是要求出11-3的结果，但是不小心重写过了func1
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}


class A{
    public int func1(int num1,int num2){
        return num1 - num2;
    }
}

class B extends A {
    public int func1(int a, int b) {            //B类重写了A类的fun1方法
        return a + b;
    }
    public int func2(int a, int b) {            //这里fun2方法又调用了fun1方法
        return func1(a, b) + 9;
    }
}



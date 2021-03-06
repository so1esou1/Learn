package com.csu.principle.liskov;
/*
    用里氏替换原则改进1里面的代码
 */
public class Liskov2 {
    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");

        B1 b = new B1();
        //因为B类不再继承A类，所有调用者不会认为func1是在求减法了，这样调用就会很明确
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));

        //使用组合仍然可以使用到A类的相关方法
        System.out.println("11-3=" + b.func3(11,3));
    }
}

//创建一个更加基础的基类
class Base{
    //把更加基础的方法和成员写到Base类中
}

class A1 extends Base{
    public int func1(int num1,int num2){
        return num1 - num2;
    }
}

class B1 extends Base {
    //如果B类需要使用A类的方法，使用组合的关系
    private A a = new A();      //这种就实现了组合

    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    //加入我们仍然想要使用A的方法:
    public int func3(int a,int b){
        return this.a.func1(a,b);
    }
}




package com.csu.principle.segregation;
/*
接口隔离原则:
    没有使用原则前的例子:
 */
public class Segregation1 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());     //这就叫A类通过接口去依赖B类
        a.depend2(new B());
        a.depend3(new B());
        /*
        B中实现了operation1
        B中实现了operation2
        B中实现了operation3
         */

        C c = new C();
        c.depend1(new D());     //C类通过接口去依赖(使用)D类
        c.depend4(new D());
        c.depend5(new D());
        /*
        D中实现了operation1
        D中实现了operation4
        D中实现了operation5
         */
    }
}

/*
//接口
interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class D implements Interface1{
    public void operation1(){
        System.out.println("D中实现了operation1");
    }
    public void operation2(){
        System.out.println("D中实现了operation2");
    }
    public void operation3(){
        System.out.println("D中实现了operation3");
    }
    public void operation4(){
        System.out.println("D中实现了operation4");
    }
    public void operation5(){
        System.out.println("D中实现了operation5");
    }
}

class B implements Interface1{
    public void operation1(){
        System.out.println("B中实现了operation1");
    }
    public void operation2(){
        System.out.println("B中实现了operation2");
    }
    public void operation3(){
        System.out.println("B中实现了operation3");
    }
    public void operation4(){
        System.out.println("B中实现了operation4");
    }
    public void operation5(){
        System.out.println("B中实现了operation5");
    }
}


class A{            //A类通过接口Interface1 依赖(使用)B类，但是只会用到1，2，3方法
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend2(Interface1 i){
        i.operation2();
    }
    public void depend3(Interface1 i){
        i.operation3();
    }
}

class C{            //C类通过接口Interface1 依赖(使用)D类，但是只会用到1，4，5方法
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend4(Interface1 i){
        i.operation4();
    }
    public void depend5(Interface1 i){
        i.operation5();
    }
}
 */

//接口1
interface Interface1{
    void operation1();
}
//接口2
interface Interface2{
    void operation2();
    void operation3();
}
//接口3
interface Interface3{
    void operation4();
    void operation5();
}


class B implements Interface1,Interface2{
    public void operation1(){
        System.out.println("B中实现了operation1");
    }
    public void operation2(){
        System.out.println("B中实现了operation2");
    }
    public void operation3(){
        System.out.println("B中实现了operation3");
    }
}

class D implements Interface1,Interface3{
    public void operation1(){
        System.out.println("D中实现了operation1");
    }
    public void operation4(){
        System.out.println("D中实现了operation4");
    }
    public void operation5(){
        System.out.println("D中实现了operation5");
    }
}

class A{            //A类通过接口Interface1 依赖(使用)B类，但是只会用到1，2，3方法
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend2(Interface2 i){
        i.operation2();
    }
    public void depend3(Interface2 i){
        i.operation3();
    }
}

class C{            //C类通过接口Interface1 依赖(使用)D类，但是只会用到1，4，5方法
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend4(Interface3 i){
        i.operation4();
    }
    public void depend5(Interface3 i){
        i.operation5();
    }
}
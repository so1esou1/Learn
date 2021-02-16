package com.csu.javase.Abstract;
/*
8、非抽象类的子类去继承有抽象方法的抽象类的话，必须去实现这个抽象方法(因为抽象方法必须出现在抽象类中)

9、面向抽象，降低程序耦合度，提高程序扩展力，这种编程符合OCP原则

 */
public class AbstractTest02 {
    public static void main(String[] args) {
        Animal a = new Bird();    //这就是面向抽象编程
        //编译时绑定的是Animal的move方法，执行时调用的是bird的move方法
        a.move();
    }
}

//动物类
abstract class Animal{
    //抽象方法
    public abstract void move();
}
//子类（非抽象类）
class Bird extends Animal{
    public void move(){
        //重写/实现抽象类中方法
        System.out.println("鸟儿在飞行");
    }
}

package com.csu.javase.Final;
/*
final修饰的实例变量，一般添加static修饰
因为不会改变，直接让所有对象都共享这一个变量，不用每个对象都创建一个这个变量，节省内存
 */
public class FinalTest06 {
    public static void main(String[] args) {
        System.out.println(Chinese.COUNTRY);
    }
}
class  Chinese{
    String idCard;
    String name;
    //既然这里的值不会改变，还有必要声明为实例变量吗？
    //实例变量被final修饰了，实例变量的值不会随着对象的变化而变化
    static final String COUNTRY = "";
}

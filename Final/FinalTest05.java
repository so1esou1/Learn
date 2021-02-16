package com.csu.javase.Final;
//final修饰的实例变量必须手动赋值，不赋值会报错，可以在构造方法中赋值
public class FinalTest05 {
    public static void main(String[] args) {

    }
}
class User{
    //实例变量
    final int age = 1;
    //实例变量在构造方法中赋值/初始化,可以在构造方法中赋值
    final double weight;
    public User(){
        this.weight = 80;
    }
    //只要赶在系统赋默认值之前就行

}

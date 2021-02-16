package com.csu.javase.Final;

public class FinalTest04 {
    public static void main(String[] args) {
        final Person p = new Person(30);
        //p = new Person(30);
        //引用也是一个变量，引号指向的是一个地址，跟30这个值没有关系
    }
}

class Person{
    int age;
    public Person(){
    }
    public Person(int age){
        this.age = age;
    }
}


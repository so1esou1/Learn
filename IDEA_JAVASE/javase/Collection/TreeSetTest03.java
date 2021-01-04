package com.bjpowernode.javase.Collection;

import java.util.TreeSet;

/*
对自定义类型，TreeSet可以排序吗？
    不可以，以下程序中对于Person类型来说无法排序。因为没有指定Person对象之间的比较规则
    谁大谁小没有说明

    以下程序运行时出现异常：java.lang.ClassCastException
                            class com.bjpowernode.javase.Collection.
                            Person cannot be cast to class java.lang.Comparable
    无法实现comparable
 */
public class TreeSetTest03 {
    public static void main(String[] args) {
        Person p1 = new Person(32);
        Person p2 = new Person(20);
        Person p3 = new Person(30);
        Person p4 = new Person(25);

        //创建TreeSet集合
        TreeSet<Person> persons = new TreeSet<>();
        //添加元素
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        //遍历
        for (Person p : persons){
            System.out.println(p);   //程序报错
        }
    }
}
class Person{
    int age;
    public Person(int age){
        this.age = age;
    }
    //重写toString方法
    public String toString(){
        return "Person[age="+age+"]";
    }
}
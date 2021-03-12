package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.reflect.Constructor;

/*
    获取运行时类的构造器
 */
public class ReflectTest8 {
    public static void main(String[] args) {
        Class clazz = People.class;


        //拿到运行时类的声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }

        //拿到运行时类的所有的构造器,不考虑权限修饰符
        Constructor[] dcs = clazz.getDeclaredConstructors();
        for (Constructor c : dcs){
            System.out.println(c);
        }
    }
}

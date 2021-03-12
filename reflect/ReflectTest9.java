package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
    获取运行时类的父类
 */
public class ReflectTest9 {
    public static void main(String[] args) {
        Class clazz = People.class;

        //1、获取父类:
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);     //class com.bjpowernode.java2.bean.Creature

        //2、获取运行时的带泛型的父类:
        Type gs = clazz.getGenericSuperclass();         //Type是一种接口
        System.out.println(gs);         //com.bjpowernode.java2.bean.Creature<java.lang.String>

        //3、获取运行时的父类的泛型:
        ParameterizedType parameterizedType = (ParameterizedType) gs;       //先做一个强转，转成一个带参数的类型
        Type[] ata = parameterizedType.getActualTypeArguments();//获取实际上的参数，即泛型参数
        for (Type pa : ata){
            System.out.println(pa);         //class java.lang.String
            System.out.println(pa.getTypeName());       //java.lang.String
        }


        //获取运行时类实现的接口(父类的拿不到):
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
            /*
            interface java.lang.Comparable
            interface com.bjpowernode.java2.bean.MyInterface
             */
        }
        //获取父类的接口:
        clazz.getSuperclass().getInterfaces();


        //获取运行时类所在的包:
        Package pack = clazz.getPackage();
        System.out.println(pack);


        //获取运行时类声明的注解:
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation an : annotations){
            System.out.println(an);
        }
    }
}

package com.bjpowernode.java2.reflect;

import java.util.Random;

/*
    体会反射的动态性
 */
public class ReflectTest5 {
    public static void main(String[] args) {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.bjpowernode.java2.reflect.Person";
                break;
        }
        ReflectTest5 rt5 = new ReflectTest5();
        try {
            //不管是哪个类，这里都是通用的:
            Object obj = rt5.getInstance(classPath);

            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //创建一个指定类的对象
    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}

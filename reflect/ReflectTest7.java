package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
    获取运行时类的方法结构:

 */
public class ReflectTest7 {
    public static void main(String[] args) {
        Class clazz = People.class;

        //(1)、getMethods()获取运行时类及其父类中所有声明为public的方法：
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);

        }

        //(2)、getDeclaredMethods()获取当前运行时类中所有public的方法,不包含父类中的方法
        System.out.println("==========================");
        Method[] dm = clazz.getDeclaredMethods();
        for (Method m : dm){
            System.out.println(m);
        }
        //(3)、获取构造器与获取方法的形式一致



        //(4)、获取方法具体的结构:权限修饰符、返回值类型、方法名(参数类型1，形参名1...)、异常抛出

        for (Method m : dm){
            //1、获取方法的注解:
            Annotation[] an = m.getAnnotations();
            for (Annotation a : an){
                System.out.println(a);          //@com.bjpowernode.java2.bean.MyAnnotation("hello")
            }


            //2、获取权限修饰符（与属性类似）
            System.out.println(Modifier.toString(m.getModifiers()) + "\t");


            //3、返回值类型
            System.out.println(m.getReturnType().getName() + "\t");


            //4、方法名
            System.out.println(m.getName() + "\t");


            //5、形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){      //表示没有参数的情况
                for (Class p : parameterTypes){
                    System.out.print(p.getName());
                }
            }


            //6、抛出的异常:
            Class[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length == 0)){
                for (int i = 0;i < exceptionTypes.length;i++){
                    System.out.println(exceptionTypes[i].getName());
                }
            }
        }

    }
}

package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
    获取运行时类的所有属性结构及其内部结构（获取bean中的People类）
 */
public class ReflectTest6 {
    public static void main(String[] args) {
        Class clazz = People.class;

        //获取属性结构:
        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println(f);      //getFileds()这种方法只能得到public公开的属性
            /*
            public int com.bjpowernode.java2.bean.People.id
            public double com.bjpowernode.java2.bean.Creature.weight
             */
        }

        System.out.println("============================================");

        //
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);          //获取当前运行时类声明的所有的属性，不考虑权限。但是父类的属性没有获取到
            /*
            private java.lang.String com.bjpowernode.java2.bean.People.name
            int com.bjpowernode.java2.bean.People.age
            public int com.bjpowernode.java2.bean.People.id
             */
        }


        //还可以拿到属性的具体的结构:权限修饰符、数据类型、变量名
        for (Field f : declaredFields) {
            //1、权限修饰符：
            int mod = f.getModifiers();
            System.out.println(mod);
            System.out.println(Modifier.toString(mod));     //这种方法可以翻译成对应的权限
                /*
                给每个权限修饰符分配了一个数
                2       private
                0       default
                1       public
                 */

            //2、数据类型:
            Class type = f.getType();
            System.out.println(type.getName() + "\t");

            //3、变量名
            String fname = f.getName();
            System.out.println(fname);
            System.out.println("============================");
        }
    }
}

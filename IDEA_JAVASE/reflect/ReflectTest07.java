package com.bjpowernode.java.reflect;

import com.bjpowernode.java.bean.Student;

import java.lang.reflect.Field;

/*
怎么通过反射机制访问一个java对象的属性？（必须掌握）
    给属性赋值set
    获取属性的值get

 */
public class ReflectTest07 {
    public static void main(String[] args) throws Exception{
        //回顾：不使用反射机制怎么访问对象的属性？
        Student s = new Student();
        //给属性赋值
        s.no = 1111;//三要素：s、no、1111
        //读属性的值
        System.out.println(s.no);//两要素

        //使用反射机制：
        //首先还是获取整个Class
        Class studentClass = Class.forName("com.bjpowernode.java.bean.Student");
        Object obj = studentClass.newInstance();  //obj就是Student对象（底层调用无参数构造方法）

        //获取no属性(属性间依靠名字来区分)
        Field noField = studentClass.getDeclaredField("no");  //单独获取一个属性的方法

        //给obj对象(Student对象)的no属性赋值
        noField.set(obj,22222);  //给obj对象的no属性赋值22222，也是三要素
        //反射机制让代码复杂了，但更灵活

        //读取属性的值
        System.out.println(noField.get(obj));//两要素

        //可以访问私有的属性吗？
        Field nameField = studentClass.getDeclaredField("name");
        //直接访问访问不了，需要打破封装
        nameField.setAccessible(true);//这是反射机制的缺点：容易打破封装，可能给不法分子机会
        //这样设置完，在外部也可以访问private的
        //给name属性赋值
        nameField.set(obj,"jackson");
        //获取name属性的值
        System.out.println(nameField.get(obj));
    }
}
//一般学框架的时候才需要用到
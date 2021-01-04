package com.bjpowernode.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
反射Student类中所有的Field
 */
public class ReflectTest05 {
    public static void main(String[] args) throws Exception{
        //Field翻译成字段，其实就是属性/成员
        //第一步：获取整个类
        Class studentClass = Class.forName("com.bjpowernode.java.bean.Student");

        String className = studentClass.getName();
        System.out.println("完整类名：" + className);   //完整类名：com.bjpowernode.java.bean.Student

        String simpleName = studentClass.getSimpleName();
        System.out.println("简类名：" + simpleName);  //简类名：Student


        //获取类中所有的Field
        Field[] fields = studentClass.getFields();  //获取Field的数组
        System.out.println(fields.length);  //测试数组中只有一个元素

        //取出这个Field
        Field f = fields[0];
        //取出Field它的名字
        String fieldName = f.getName();
        System.out.println(fieldName);  //无论student类怎么修改，都是返回no
        //说明：Field获取的是所有公开的public的属性

        //获取所有Field的方法：
        Field[] fs = studentClass.getDeclaredFields();
        System.out.println(fs.length);  //长度是4

        //遍历
        for(Field field : fs){
            //获取属性的名字
            System.out.println(field.getName());  //这四个属性的名字都拿到了

            //获取属性的类型
            Class fieldType = field.getType();  //getType()返回Class
            String fName = fieldType.getName();
            System.out.println(fName);

            //获取属性的修饰符的方法：
            int i =  field.getModifiers();  //返回的是修饰符的编号
            //把修饰符转化成字符串
            String modifierString = Modifier.toString(i);  //这个方法可以进行转换
            System.out.println(i);
            System.out.println(modifierString);
        }
        //可以猜测方法名，慢慢养成这个习惯，以后开发中遇到新的技术，可以猜测先，猜不到再查阅文档，这样开发效率高一些
    }
}

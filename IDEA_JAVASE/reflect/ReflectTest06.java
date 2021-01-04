package com.bjpowernode.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
反编译：通过反射机制反编译一个类的属性Field(了解一下，开发反编译器的才有用)
 */
public class ReflectTest06 {
    public static void main(String[] args) throws Exception{
        //创建这个是为了拼接字符串
        StringBuilder s = new StringBuilder();

        Class studentClass = Class.forName("java.lang.String");

        s.append(Modifier.toString(studentClass.getModifiers()) + " class " + studentClass.getSimpleName() + " { \n");

        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields){
            s.append("\t");  //追加提行
            s.append(Modifier.toString(field.getModifiers()));  //追加修饰符
            s.append(" "); //追加空格
            s.append(field.getType().getSimpleName());  //追加类型
            s.append(" "); //追加空格
            s.append(field.getName()); //追加名字
            s.append(";\n");  //追加分号和换行
        }

        s.append("}");
        System.out.println(s);  //最终输出String中的内容

    }
}

package com.bjpowernode.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
反编译method（了解内容）
 */
public class ReflectTest09 {
    public static void main(String[] args) throws Exception{
        StringBuilder s = new StringBuilder();

        Class userServiceClass = Class.forName("com.bjpowernode.java.service.UserService");
        s.append(Modifier.toString(userServiceClass.getModifiers()) + " class " + userServiceClass.getSimpleName() + "{\n");

        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method : methods){
            s.append("\t");//追加缩进
            s.append(Modifier.toString(method.getModifiers()));//追加修饰符
            s.append(" "); //追加空格
            s.append(method.getReturnType().getSimpleName()); //追加返回值类型
            s.append(" "); //追加空格
            s.append(method.getName());  //追加名字
            s.append("(");//追加左小括号
            //追加参数列表
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType : parameterTypes){
                s.append(parameterType.getSimpleName());
                s.append(",");//追加逗号,最后会多一个逗号
            }
            //s.substring(0,s.length());截取一部分，就可以没有最后一个逗号
            s.deleteCharAt(s.length() - 1); //这样可以删除最后一个逗号
            s.append("){}\n");//追加右小括号和大括号

        }


        s.append("}");
        System.out.println(s);
    }
}

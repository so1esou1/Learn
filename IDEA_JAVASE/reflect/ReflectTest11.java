package com.bjpowernode.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
反编译一个类的constructor构造方法
 */
public class ReflectTest11 {
    public static void main(String[] args) throws Exception{
        StringBuilder  s = new StringBuilder();
        Class vipClass = Class.forName("com.bjpowernode.java.bean.Vip");
        s.append(Modifier.toString(vipClass.getModifiers()));
        s.append(" class ");
        s.append(vipClass.getSimpleName());
        s.append("{\n");

        //拼接构造方法
        Constructor[] constructors = vipClass.getConstructors();
        for (Constructor constructor : constructors){
            s.append("\t");
            s.append(Modifier.toString(constructor.getModifiers()));
            s.append(" ");
            s.append(vipClass.getSimpleName());
            s.append("(");
            //拼接参数
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes){
                s.append(parameterType.getSimpleName());
                s.append(",");
            }
            //如果括号内大于0，删除最后下标上的字符
            if (parameterTypes.length > 0){
                s.deleteCharAt(s.length() - 1);
            }
            s.append("){}\n");
        }
        s.append("}");
        System.out.println(s);
    }
}

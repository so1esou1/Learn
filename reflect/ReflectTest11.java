package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.reflect.Field;

/*
    调用修改运行时类中指定的结构2:属性2
 */
public class ReflectTest11 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = People.class;
        //创建运行时类的对象
        People p = (People) clazz.newInstance();

        //获取指定属性(常用的方式)
        Field name = clazz.getDeclaredField("name");        //获取指定变量名的属性

        //***必须进行这个设置才能访问到被private修饰的属性!!!
        name.setAccessible(true);

        //设置属性:
        name.set(p,"tom");
        System.out.println(name.get(p));        //tom
    }
}

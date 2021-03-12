package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.reflect.Field;

/*
    调用修改运行时类中指定的结构1:属性1
 */
public class ReflectTest10 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = People.class;
        //创建运行时类的对象
        People p = (People) clazz.newInstance();

        //要求属性必须是声明为public,但是一般声明为public的属性较少，所以一般不用这种方式
        Field id = clazz.getField("id");        //id属性是public声明的，可以使用这种方法

        //设置当前属性的值
        id.set(p,1001);   //set()方法，参数一:指明设置哪个对象的属性  参数二:将此属性值设置为多少
        //获取当前属性的值
        int pId = (int)id.get(p);   //强制，原来是包装类
        System.out.println(pId);        //1001,如果之前没有set设置，就是0(空参构造器)

    }
}

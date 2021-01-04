package com.bjpowernode.java.reflect;

import com.bjpowernode.java.bean.User;

/*
获取到Class能干什么？

    通过Class的newInstance()方法来实例化对象
    注意：newInstance()方法内部实际上调用的无参数构造方法，必须保证无参构造存在才可以，没有的话会出现异常
 */
public class ReflectTest02 {
    public static void main(String[] args) {
        //不使用反射机制创建对象
        User user = new User();
        System.out.println(user);



        //下面是以反射机制的方式创建对象
        try {
            //通过反射机制获取Class。通过class来实例化对象
            Class c = Class.forName("com.bjpowernode.java.bean.User");

            //newInstance()这个方法会调用User这个类的无参数构造方法完成对象的创建
            //重点是newInstance()调用的是无参数构造方法，必须保证无参数构造是存在的
            try {
                Object obj = c.newInstance();
                System.out.println(obj);  //com.bjpowernode.java.bean.User@7ef20235
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

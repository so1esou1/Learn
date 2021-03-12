package com.bjpowernode.java2.reflect;
/*
    通过反射创建对应的运行时类的对象
    newInstance():创建对应的运行时类对象,内部封装了相应运行时类的空参的构造器（因为造对象都得用到构造器）
    要想此方法正常地创建运行时类对象，要求:
        1、运行时类必须提供空参的构造器
        2、空参的构造器的访问权限要足够，通常设置为public

        在javabean中要求提供一个public的空参构造器，原因:
        1、便于通过反射创建运行时类的对象
        2、便于子类继承此运行时类，默认调用super()时，保证父类有此构造器
 */
public class ReflectTest4NewInstance1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Person person = (Person)clazz.newInstance();
        System.out.println(person);     //Person{name='null', num=0}    创建了一个默认数值的对象
    }
}

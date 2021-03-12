package com.bjpowernode.java2.reflect;
/*
    获取Class实例的四种方式:
方式一(用得不多):调用运行时类的属性:  .class
方式二:通过运行时类的对象
方式三(用的多,这种体现了动态性):调用Class的静态方法:forName(String classPath)(因为这里写的是全类名，编译期容易通过，运行期动态地加载对象)
方式四(了解):调用类的加载器:ClassLoader

    动态性的理解:在运行期，需要加载哪个类，才会去加载。不要在编译期就定死
 */
public class ReflectTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一:调用运行时类的属性:  .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);     //class com.bjpowernode.java2.reflect.Person



        //方式二:通过运行时类的对象
        Person p = new Person();
        Class clazz2 = p.getClass();



        //方式三:调用Class的静态方法:forName(String classPath)        ***全类名:包括包名在内的路径名字
        Class clazz3 = Class.forName("com.bjpowernode.java2.reflect.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);       //true
        System.out.println(clazz1 == clazz3);       //true
        //这三种方式获取的内存地址都是一样的!!!都是同一个



        //方式四:调用类的加载器:ClassLoader
        ClassLoader classLoader = ReflectTest2.class.getClassLoader();
        //使用ReflectTest2的类加载器加载Person类
        Class clazz4 = classLoader.loadClass("com.bjpowernode.java2.reflect.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);       //true
    }
}




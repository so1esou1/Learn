package com.bjpowernode.java2.reflect;
/*
    了解类的加载器
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        //对应自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest1.class.getClassLoader();
        System.out.println(classLoader);    //jdk.internal.loader.ClassLoaders$AppClassLoader@2f0e140b  系统类加载器
        //调用系统类加载的getParent():获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);         //jdk.internal.loader.ClassLoaders$PlatformClassLoader@16b98e56
        //调用扩展类加载器的getParent()，无法获得引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);        //null.获取不到了
        //引导类加载器主要赋值加载java的核心类库，是无法加载自定义类的
    }
}

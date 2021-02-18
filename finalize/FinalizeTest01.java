package com.csu.javase.Object.finalize;

/*
  关于Object类中的finalize()方法(JDK9之后过时了)
    1、源代码:
    protected void finalize() throws Throwable { }

    2、finalize()只有一个方法体，里面没有代码，而且是由protected修饰

    3、这个方法不需要程序员手动调用，JVM的垃圾回收器GC负责调用这个方法

    4、finalize()方法的执行时期：
      当一个java对象即将被垃圾回收器回收的时候，垃圾回收器负责调用finalize()方法

    5、finalize()方法实际上是SUN公司为程序员准备的一段时期，垃圾销毁时期
    如果希望在对象销毁时机执行一段代码的话，这段代码要写到finalize方法当中。(遗书)(有点类似于静态代码块)

    6、equals和toString是需要程序员调用的，finalize()方法只需要重写，不需要调用，到时候GC会自动调用
    比如项目中有这样的需求：所有的对象被JVM释放时记录一下释放时间。这个负责记录的代码就写入finalize中

    7、提示：java中的垃圾回收器不是轻易会启动的，垃圾太少或时间没到有可能启动有可能不启动
    使用System.gc();   建议启动垃圾回收器，这样的话回收的效率会高一些
 */
public class FinalizeTest01 {
    public static void main(String[] args) {
        //创建对象
        Person p = new Person();
        //垃圾回收器调用p.finalize();
        //怎么把Person对象变成垃圾？
        //让p等于空
        p = null;

        System.gc();          //建议垃圾回收器
    }
}
class Person{
    //重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("即将被销毁");
    }
}

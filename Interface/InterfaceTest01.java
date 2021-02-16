package com.csu.javase.Interface;

/*
1、接口也是一种引用数据类型

2、接口是完全抽象的，抽象类是半抽象的，或者也可以说接口是特殊的抽象类

3、语法:
[修饰符列表] interface 接口名{}

4、接口编译之后也是一个class字节码文件

5、接口支持多继承，一个接口可以继承多个接口

6、接口中只允许出现两部分内容：常量+抽象方法
接口中既然都是抽象方法，那么抽象方法定义时public abstract可以省略
同理,接口中常量public static final也能省略,常量不能进行更改

7、类和类叫做继承(extends)，类和接口之间叫做实现(implements)。仍然可以把实现看作是一种特殊的继承

8、实现接口，要么是抽象类，要么重写/实现接口中的方法
*****当一个非抽象的类实现接口方法的话必须把接口中所有的方法都重写

9、类可以继承多个接口,需要把每个接口中的方法全都重写，这种机制弥补了java中的类和类中的单继承缺陷

10、实际上单继承是为了简单而定义的，现实世界中是有多继承的

11、继承和实现都存在的话，extends关键字在前，implements关键字在后

12、接口在开发中的作用：
        多态的作用：面向抽象编程，不要面向具体编程，降低程序耦合度，提高程序扩展力
        面向抽象编程这句话可以改成面向接口编程(接口是完全抽象的)，有了接口就有了可插拔，可插拔代表扩展力强

13、但凡是满足has a的，都以属性的形式存在(I have a pen)
凡是满足is a的表示都可以设置为继承(Cat is a Animal)
凡是满足like a关系的表示“实现关系”(Cooker like a FoodMenu厨师像一个菜单),实现关系一般是类实现接口

14、接口的使用为什么离不开多态机制？
  接口加上多态才可以达到解耦合
*****任何一个接口都有调用者和实现者。接口可以将调用者和实现者解耦合。调用者面向接口调用；实现者面向接口编写实现
(删掉一个调用者或者实现者，另一方和接口组合可以编译通过，说明解耦得不错)


15、抽象类和接口有什么区别?
  语法上的区别:抽象类是半抽象的，接口是完全抽象的；抽象类这有构造方法，接口中没有构造方法；
接口间支持多继承，类和类之间只能单继承；一个类可以同时实现多个接口，一个抽象类只能继承一个类(单继承);
接口中只允许出现常量和抽象方法；以后接口使用得比抽象类多，抽象类一般使用得少。接口一般是对“行为”的抽象
 */


public class InterfaceTest01 {

}
interface A{}

interface B{}

interface C extends A,B{}

interface MyMath{
    public abstract int sum(int a,int b);
    //接口中既然都是抽象方法，那么public abstract可以省略
    int sub(int a,int b);

    public static final double PI = 3.1415926;
    //接口中常量public static final同理也能省略
    double TAI = 3.14;
}

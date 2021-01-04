package com.bjpowernode.javase.integer;
/*
     1、java中为8种基本数据类型又对应准备了8种包装类型，8种包装类属于引用数据类型，父类是Object。
     2、思考：为什么要提供8种包装类？
            8种数据类型不够用，所以SUN又提供了8种包装类数据类型
 */
public class IntegerTest01 {
    //入口
    public static void main(String[] args) {
        //有没有这种需求：调用doSome()方法的时候需要传一个数字进去。
        //但是数字属于基本数据类型，而doSome()方法参数的类型是Object
        //可见doSome()方法无法接收基本数据类型的数字，那可以传一个数字对应的包装类进去
        //把100这个数字经过构造方法包装成对象
        MyInt myInt = new MyInt(100);
        //doSome()方法虽然不能直接传100，但是可以传一个100对应的包装类型。
        doSome(myInt);

    }

    public static void doSome(Object obj){
        System.out.println(obj.toString());//重写toString方法之前：com.bjpowernode.javase.integer.MyInt@7ef20235 重写之后：100
    }
}

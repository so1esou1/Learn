package com.bjpowernode.javase.Collection;
/*
自定义泛型
    自定义泛型的时候<>里面是一个标识符，随便写，java源代码中经常出现的是<E>和<T>,E:element,T:type
 */
public class GenericTest03<abcdertyui> {  //<>里面随便写的
    public void doSome(abcdertyui o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        //new对象的时候指定了泛型是：String类型
        GenericTest03<String> gt = new GenericTest03<>();
        gt.doSome("abc");

        //================================================
        GenericTest03<Integer> gt2 = new GenericTest03<>();
        gt2.doSome(100);
    }
}

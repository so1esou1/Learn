package com.bjpowernode.java2.JDK8;

import java.util.function.Consumer;

/*
    lambda表达式的使用

    1、举例:(o1,o2) -> Integer.compare(o1,o2);
    2、格式:
        ->:lambda操作符或箭头操作符
        ->的左边:lambda形参列表，其实就是接口中的抽象方法的形参列表
        ->的右边:lambda体，其实就是重写的抽象方法的方法体
    3、Lambda表达式的使用:
        总结:
        ->左边:lambda形参列表的参数类型可以省略(类型推断):如果lambda形参列表只有一个参数，其一对()也可以省略
        ->右边:lambda体应该使用{}进行包裹，如果lambda体只有一条执行语句(可能是return语句)，可以省略这一对{}和return语句.


    4、lambda表达式的本质:在java中，万事万物皆对象，lambda表达式是接口的实例

    5、要使用lambda表达式的接口的要求:只有一个抽象方法(函数式接口)
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        //使用方式一、语法格式一:无参，无返回值:
        /*

        Runnable r2 = () -> System.out.println("一三一四");
        r2.run();
         */

        //使用方式二、lambda需要一个参数，但是没有返回值:
        /*
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("二啊实打实");

        System.out.println("改成lambda表达式:");
        Consumer<String> con1 = (String s) -> {System.out.println(s);};
        con1.accept("速度放缓")
        */

        //使用方式三、数据类型可以省略，因为可以有编译器推断得出，称为"类型推断"
        //Consumer<String> con = (str) ->{ System.out.println(str); };


        //使用方式四、Lambda 若只需要一个参数时，参数的小括号可以省略(有什么用啊喂)
        //Consumer<String> con = str ->{ System.out.println(str); };


        //使用方式五、Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        //Consumer<String> con = (o1,o2) ->{ System.out.println(o1);System.out.println(o2); };


        //使用方式六:当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        //Consumer<String> con = str -> System.out.println(str); ;
    }
}

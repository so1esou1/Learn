package com.bjpowernode.java2.JDK8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    1、Stream 和 Collection 集合的区别：Collection 是一种静态的内存数据结构，而 Stream 是有关计算的。
      前者是主要面向内存，存储在内存中，后者主要是面向 CPU，通过 CPU 实现计算
    2、①Stream 自己不会存储元素。
        ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
        ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
     3、Stream 的操作三个步骤：
     1- 创建 Stream：一个数据源（如：集合、数组），获取一个流
    2- 中间操作：一个中间操作链，对数据源的数据进行处理
     3- 终止操作(终端操作) ：一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */
public class StreamAPITest1 {
    public static void main(String[] args) {
        //创建Stream的方式一：通过集合:

        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();         //返回一个顺序流(顺序返回)
        Stream<Integer> ps = list.parallelStream();     //返回一个并行流(并行操作，不保证顺序)


        //创建Stream的方式二：通过数组
        int[] arr = {1,2,3,4,5,6};
        IntStream stream1 = Arrays.stream(arr);



        //创建Stream的方式三：通过Stream类本身的of()添加元素
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);        //看作是包装类对象


        //创建Stream的方式四：创建无限流(使用少)
        /*
        迭代：
        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        */
        //遍历前10个偶数:
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out :: println);//limit是限制

        /*
        生成：
        public static<T> Stream<T> generate(Supplier<T> s)
         */
        //输出10个随机数
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);

    }
}

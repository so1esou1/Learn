package com.bjpowernode.java2.JDK8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    Stream的中间操作
    多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
而在终止操作时一次性全部处理，称为“惰性求值”。
 */
public class StreamAPITest2 {
    public static void main(String[] args) {

        /*
            1、筛选与切片
            filter(Predicate p)         接收 Lambda ， 从流中排除某些元素，过滤
            distinct()              筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
            limit(long maxSize)     截断流，使其元素不超过给定数量
            skip(long n)    跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
         */

        //filter过滤:
        /*List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary > 7000).forEach(System.out :: println);
            过滤工资小于7000的员工
         */


        //截断流:见StreamAPITest1

        //跳过元素:
        //list.stream().skip(3).forEach(System.out :: println);     跳过前三个

        //筛选:
        //list.stream().distinct().forEach(System.out :: println);
    }
}

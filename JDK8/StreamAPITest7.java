package com.bjpowernode.java2.JDK8;

import java.util.stream.Collectors;

/*
    Stream 的终止操作3-收集

    collect(Collector c)        将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法

    Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)


    Collector接口中的方法:
        toList List<T>      把流中元素收集到List
        toSet Set<T>        把流中元素收集到Set
        toCollection Collection<T>      把流中元素收集到创建的集合
        counting Long       计算流中元素的个数
        summingInt Integer  对流中元素的整数属性求和
        averagingInt Double     计算流中元素Integer属性的平均值
        summarizingInt IntSummaryStatistics     收集流中Integer属性的统计值。如：平均值
 */
public class StreamAPITest7 {
    public static void main(String[] args) {
        //toList()方法:
        //employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
    }
}

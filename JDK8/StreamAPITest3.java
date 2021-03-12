package com.bjpowernode.java2.JDK8;

import java.util.Arrays;
import java.util.List;

/*
    Stream 的中间操作2-映 射map

    map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。

    mapToDouble(ToDoubleFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。

    mapToInt(ToIntFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。

    mapToLong(ToLongFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。

    flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 */
public class StreamAPITest3 {
    public static void main(String[] args) {
        //map:
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);

        //flatMap:map是将每个元素进行映射，flatMap是将所有元素看作一个整体映射出去

    }
}

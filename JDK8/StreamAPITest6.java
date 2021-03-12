package com.bjpowernode.java2.JDK8;

import java.util.Arrays;
import java.util.List;

/*
    Stream 的终止操作2-归约

    reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
    reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
 */
public class StreamAPITest6 {
    public static void main(String[] args) {
        //计算1-10的自然数的和:
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

}

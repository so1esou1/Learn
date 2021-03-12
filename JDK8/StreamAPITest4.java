package com.bjpowernode.java2.JDK8;

import java.util.Arrays;
import java.util.List;

/*
    Stream 的中间操作3-排序
        sorted()                    产生一个新流，其中按自然顺序排序
        sorted(Comparator com)      产生一个新流，其中按比较器顺序排序
 */
public class StreamAPITest4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 43, 12, 43, 542, 83, 0, -23, 7);
        list.stream().sorted().forEach(System.out :: println);

        //排序类需要实现comparable接口
    }
}

package com.bjpowernode.javase.array;

import java.util.Arrays;

/*
好消息：SUN公司已经为我们程序员写好了一个数组工具类
  java.util.Arrays;
 */
public class ArraysTest02 {
    public static void main(String[] args) {
        //java.util.Arrays;  工具类中有哪些方法，我们开发时要参考API帮助文档
        //不用死记硬背
        //用的比较多的是排序和查找
        int[] arr = {3,6,5,12,1,2,32,5,5};
        //排序
        Arrays.sort(arr);
        //排序输出
        for (int i = 0;i < arr.length;i ++){
            System.out.println(arr[i]);
        }
        int index = Arrays.binarySearch(arr,32);
        System.out.println(index == -1 ? "该元素不存在" : "该元素下标是：" + index);
    }
}

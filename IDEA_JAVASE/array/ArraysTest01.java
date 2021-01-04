package com.bjpowernode.javase.array;
import java.util.Arrays;
/*
使用SUN公司提供的数据工具类：java.util.Arrays;
 */
public class ArraysTest01 {
    public static void main(String[] args) {
        int[] arr = {112,3,4,56,67,3,2,1};
        //工具类当中的方法大部分都是静态的
        Arrays.sort(arr);

        //遍历输出
        for (int i = 0 ; i < arr.length;i ++){
            System.out.println(arr[i]);//输出按从小到大排序
        }
    }
}

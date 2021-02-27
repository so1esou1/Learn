package com.csu.sort.shellsort;

import java.util.Arrays;

/*
    代码实现希尔排序1：交换法
 */
public class ShellSort1 {
    public static void main(String[] args) {
        //先定义一个数组
        int[] array = {8,9,1,7,2,3,5,4,6,0};
        Shell(array);

    }



    //定义希尔排序方法  交换法
    public static void Shell(int[] array){
        int temp = 0;
        //第一轮
        //因为第一轮排序是将10个数据分成5组
        for (int i = 5;i < array.length;i ++){
            //遍历各组中所有的元素(共有5组，每组有两个元素)，步长是5
            for (int j = i - 5;j >= 0;j -= 5){
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (array[j] > array[j + 5]){
                    temp = array[j];
                    array[j] = array[j + 5];
                    array[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序第1轮之后的结果是:");
        System.out.println(Arrays.toString(array));     //[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]


        //第2轮
        //第2轮排序将10个数据分成了5/2=2组
        for (int i = 2;i < array.length;i ++){
            //遍历各组中所有的元素(共有5组，每组有两个元素)，步长是5
            for (int j = i - 2;j >= 0;j -= 2){
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (array[j] > array[j + 2]){
                    temp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序第2轮之后的结果是:");
        System.out.println(Arrays.toString(array));         //[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]


        //第3轮
        //第3轮排序将10个数据分成2/2=1组
        for (int i = 1;i < array.length;i ++){
            //遍历各组中所有的元素(共有5组，每组有两个元素)，步长是5
            for (int j = i - 1;j >= 0;j -= 1){
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第3轮之后的结果是:");
        System.out.println(Arrays.toString(array));         //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}

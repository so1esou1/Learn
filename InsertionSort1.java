package com.csu.sort.insertionsort;

import java.util.Arrays;

/*
    实现插入排序算法1
 */
public class InsertionSort1 {
    public static void main(String[] args) {
        //先定义一个数组
        int[] arr = {101,34,119,1};
        insertSort(arr);
    }


    //插入排序的方法
    //使用逐步推导的方式来理解
    public static void insertSort(int[] arr){
        //第一轮
        int insertValue = arr[1];       //先定义待插入的数
        int insertIndex = 1 - 1;            //定义要被插入的数的索引

        //给insertValue找到插入的位置
        //insertIndex >= 0   是保证数组不越界
        //insertValue < arr[insertIndex]    待插入数还没有找到适当的位置插入
        //就需要将arr[insertIndex]后移
        while (insertIndex >= 0 && insertValue < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];        //将arr[insertIndex]后移
            insertIndex --;     //终止while的操作
        }
        //当退出while循环时，说明插入的位置找到，insertIndex + 1
        arr[insertIndex + 1] = insertValue;

        System.out.println("第1轮插入后:");
        System.out.println(Arrays.toString(arr));       //[34, 101, 119, 1]



        //第二轮
        insertValue = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex --;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第2轮插入后:");
        System.out.println(Arrays.toString(arr));           //[34, 101, 119, 1]



        //第3轮
        insertValue = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex --;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第3轮插入后:");
        System.out.println(Arrays.toString(arr));           //[1, 34, 101, 119]
    }
}



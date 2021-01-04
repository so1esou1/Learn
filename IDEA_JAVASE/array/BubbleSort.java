package com.bjpowernode.javase.array;
/*
冒泡排序算法
 */
public class BubbleSort {
    public static void main(String[] args) {
        //这是int类型的数组对象
        int[] arr = {3,2,7,6,8};
        //经过冒泡排序算法对以上数组中的元素进行排序
        //冒泡排序算法核心是什么？拿着3和右边相邻的2进行比较，如果左>右，交换位置。。。依次进行
        for (int i = arr.length-1;i > 0;i++){
            for (int j = 0;j < i;j++){
                if (arr[j] > arr[j+1]){
                    //交换位置
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        //输出结果
        for (int i = 0;i < arr.length;i ++){
            System.out.println(arr[i]);
        }
    }
}

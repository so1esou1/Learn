package com.csu.sort.selectsort;

import java.util.Arrays;

/*
    选择排序实现
 */
public class SelectSort1 {
    public static void main(String[] args) {
        int[] array = new int[]{101,34,119, 1};
        selectSort(array);      //第一轮：[1, 34, 119, 101]
    }


    //选择排序的方法
    public static void selectSort(int[] array){
        //使用逐步推导的方式讲解选择排序


        //第一轮
        int minIndex = 0;       //假定最小数的索引就是0
        int min = array[0];
        for (int j = 0 + 1;j < array.length;j ++){          //j从第二个数开始遍历，遍历完剩下的数
            if (min > array[j]){        //说明假定的最小并不是最小
                min = array[j];         //重置min
                minIndex = j;           //重置minIndex
            }
        }
        //将最小值放在array[0]，即交换
        if (minIndex != 0){             //如果minIndex不等于0时才交换
            array[minIndex] = array[0];
            array[0] = min;
        }
        System.out.println("第一轮后:");
        System.out.println(Arrays.toString(array));


        //第二轮
        minIndex = 1;       //假定最小数的索引就是0
        min = array[1];
        for (int j = 1 + 1;j < array.length;j ++){          //j从第二个数开始遍历，遍历完剩下的数
            if (min > array[j]){        //说明假定的最小并不是最小
                min = array[j];         //重置min
                minIndex = j;           //重置minIndex
            }
        }
        //将最小值放在array[1]，即交换
        if (minIndex != 1){
            array[minIndex] = array[1];
            array[1] = min;
        }
        System.out.println("第二轮后:");
        System.out.println(Arrays.toString(array));


        //第三轮
        minIndex = 2;       //假定最小数的索引就是0
        min = array[2];
        for (int j = 2 + 1;j < array.length;j ++){          //j从第二个数开始遍历，遍历完剩下的数
            if (min > array[j]){        //说明假定的最小并不是最小
                min = array[j];         //重置min
                minIndex = j;           //重置minIndex
            }
        }
        //将最小值放在array[2]，即交换
        if (minIndex != 2){
            array[minIndex] = array[2];
            array[2] = min;
        }
        System.out.println("第三轮后:");
        System.out.println(Arrays.toString(array));         //[1, 34, 101, 119]
    }
}

//在推导中我们发现可以使用一个循环搞定

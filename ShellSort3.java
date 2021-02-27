package com.csu.sort.shellsort;

import java.util.Arrays;

/*
    希尔排序的移动法
 */
public class ShellSort3 {
    public static void main(String[] args) {
        int[] array = {8,9,1,7,2,3,5,4,6,0};
        shell3(array);
    }


    //希尔排序，移动法
    public static void shell3(int[] array){
        //增量gap，并逐步缩小增量
        for (int gap = array.length / 2;gap > 0;gap /= 2){
            //从第gap个元素开始，对其所在的组进行直接插入排序
            for (int i = gap;i < array.length;i ++){
                int j = i;
                int temp = array[i];
                if(array[j] < array[j - gap]){
                    while ((j - gap) >= 0 && temp < array[j - gap]){
                        //移动
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    //当退出这个while循环之后就找到了插入的位置
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}

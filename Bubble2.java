package com.csu.sort.bubblesort;

import java.util.Arrays;

/*
    优化冒泡循环
 */
public class Bubble2 {
    public static void main(String[] args) {
        int array[] = {3,9,-1,10,-2};
        int temp = 0;

        //冒泡排序的时间复杂度:O(n^2)
        for (int i = 0;i < array.length - 1;i ++){
            for (int j = 0;j < array.length - 1 - i;j ++){
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "趟排序后的数组：");
            System.out.println(Arrays.toString(array));
        }

    }
}

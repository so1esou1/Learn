package com.csu.sort.shellsort;

import java.util.Arrays;

/*
    希尔排序交换法的完整版
    交换法的效率并不高，交换法时间很长的
 */
public class ShellSort2 {
    public static void main(String[] args) {
        int[] array = {8,9,1,7,2,3,5,4,6,0};
        Shell2(array);


    }


    public static void Shell2(int[] array){
        int temp = 0;
        int count = 0;      //用来计算希尔排序的次数
        //使用循环处理
        for (int gap = array.length / 2;gap > 0;gap /= 2){          //注意理解这里的循环
            for (int i = gap;i < array.length;i ++){
                //遍历各组中所有的元素(共有gap组)，步长是gap
                for (int j = i - gap;j >= 0;j -= gap){
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (array[j] > array[j + gap]){
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序" + (++count) + "轮之后的结果是:");
            System.out.println(Arrays.toString(array));
        }
    }
}

package com.csu.sort.bubblesort;

import java.util.Arrays;

/*
    实现冒泡排序
    规律：for循环都是一样的，只是循环范围变化。因此可以进行优化，把for循环整个包起来，见Bubble2
 */
public class Bubble1 {
    public static void main(String[] args) {
        int array[] = {3,9,-1,10,-2};

        //第一趟排序，就是把最大的数排在最后
        int temp = 0;
        for (int j = 0;j < array.length - 1;j ++){          //注意这里j最大只能到倒数第二个
            //如果前面的数比后面的大，则交换
            if (array[j] > array[j + 1]){
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }

        System.out.println("第一趟排序以后的数组");
        System.out.println(Arrays.toString(array));      //[3, -1, 9, -2, 10]


        //第二趟排序，就是将第二大的数排在倒数第二位,之前排好了的最大数不再参与比较
        for (int j = 0;j < array.length - 1 - 1;j ++){
            if (array[j] > array[j + 1]){
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序以后的数组");
        System.out.println(Arrays.toString(array));     //[-1, 3, -2, 9, 10]


        //第三趟排序，就是将第三大的数排在倒数第三位,之前排好了的最大数不再参与比较
        for (int j = 0;j < array.length - 1 - 1 - 1;j ++){
            if (array[j] > array[j + 1]){
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序以后的数组");
        System.out.println(Arrays.toString(array));     //[-1, -2, 3, 9, 10]


        //第四趟排序，就是将第四大的数排在倒数第四位,之前排好了的最大数不再参与比较
        for (int j = 0;j < array.length - 1 - 1 - 1 - 1;j ++){
            if (array[j] > array[j + 1]){
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序以后的数组");
        System.out.println(Arrays.toString(array));     //[-2, -1, 3, 9, 10]
    }
}

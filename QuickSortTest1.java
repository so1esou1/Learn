package com.csu.sort.quicksort;

import java.util.Arrays;

public class QuickSortTest1 {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
        quickSort(arr,0, arr.length-1);
        System.out.println("arr=" + Arrays.toString(arr));              //arr=[-567, -9, -1, 0, 23, 70, 78, 900, 4561]
    }
    public static void quickSort(int[] arr,int left,int right){         //设置左右指针
        int l = left;       //左下标
        int r = right;      //右下标
        int pivot = arr[(left + right) / 2];          //pivot：中轴
        int temp = 0;       //临时变量，为交换做准备
        //while循环的目的是让比pivot小的放到左边，比pivot大的放在右边
        while (1 < r){
            while (arr[l] < pivot){         //在pivot的左边一直找，找到一个>=pivot的值才退出
                l += 1;
            }
            while (arr[r] > pivot){         //在pivot的右边一直找，找到一个<=pivot的值才退出
                r -= 1;
            }
            //如果l >= r成立，说明pivot的左右两个的值已经全部是<=pivot的值了，右边全部是>=pivot的值
            if (l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot,则r--,前移
            if (arr[l] == pivot){
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot，则l++,后移
            if (arr[r] == pivot){
                l += 1;
            }
        }

        //判断：如果l == r,必须l++，r--，否则出现栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l){
            quickSort(arr, l, right);
        }
    }
}




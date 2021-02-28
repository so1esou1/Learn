package com.csu.search.insertvaluesearch;

import java.util.Arrays;

/*
    插值查找代码实现
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0;i < 100;i ++){
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr,0,arr.length - 1,100);
        System.out.println("index=" + index);
    }


    //编写插值查找算法
    //查找查找算法也要求数组有序
    /**
     *
     * @param arr 传入数组
     * @param left 左边索引
     * @param right 右边索引
     * @param key 要查找的值
     * @return 如果找到就返回下标，没有找到就返回-1就行
     */
    public static int insertValueSearch(int[] arr,int left,int right,int key){
        System.out.println("插值查找次数~~");         //都是一次

        if (left > right || key < arr[0] || key > arr[arr.length - 1]){      //左索引大于右索引，或者key值比最小的值小，或key值比最大的值大，就可以直接退出
            return  -1;
        }       //没有这个条件的话得到的mid可能越界

        //求出mid(套公式),自适应
        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (key > midValue){            //如果要查找的值大于中间定位的值的话,说明应该向右递归
            return insertValueSearch(arr,mid + 1,right,key);
        }
        else if (key < midValue){       //如果要查找的值小于中间定位的值的话,说明应该向左递归
            return insertValueSearch(arr,left,mid - 1,key);
        }else {         //key和midValue相等，说明已经找到了
            return mid;
        }
    }
}



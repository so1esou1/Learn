package com.csu.search.seqsearch;
/*
    实现线性查找
 */
public class Seqsearch {
    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};      //一个无序的数组
        int index = seqSearch(arr,11);
        if (index == -1){
            System.out.println("没有查找到");
        }else {
            System.out.println("找到了，下标为" + index);
        }
    }

    //线性查找的方法

    /**
     *  这里我们实现的线性查找是找到一个就返回，特别简单。如果有多个相同值要返回，需要放在集合中
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){
        //线性查找是逐一比对，发现有相同的值时就返回下标
        for (int i = 0;i < arr.length;i ++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}

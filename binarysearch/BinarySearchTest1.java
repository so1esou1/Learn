package com.csu.search.binarysearch;
/*
    二分法查找(使用递归的方式)代码实现
    注意：二分法查找要求数组必须是有序的!!!
 */
public class BinarySearchTest1 {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int resIndex = binarySearch(arr,0, arr.length-1,1);
        System.out.println("查找数的索引是:" + resIndex);
    }


    //二分法查找算法:

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param value 要查找的值
     * @return  如果找到就返回下标，没有找到就返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int value){
        if (left > right){      //当left>right时，说明递归整个数组，但是没有找到
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (value > midValue){          //向右递归
            return binarySearch(arr,mid+1,right,value);
        }else if (value < midValue){    //向左递归
            return binarySearch(arr,left,mid-1,value);
        }else {
            return mid;
        }
    }
}

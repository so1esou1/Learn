package com.csu.binarysearch;
/*
    二分查找算法(非递归型)代码实现
 */
public class BinarySearchNRec {
    public static void main(String[] args) {
        //测试
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr,67);
        System.out.println("index=" + index);
    }



    //二分查找法:
    /**
     *
     * @param arr   待查找的数组
     * @param target    需要查找的数
     * @return  返回下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){          //说明可以继续查找
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;        //这里就是和递归的区别，需要向左边查找
            }else {
                left = mid + 1;         //需要向右边查找
            }
        }
        return -1;
    }
}




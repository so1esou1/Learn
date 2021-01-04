package com.bjpowernode.javase.array;
/*
数组工具类（自己写的，不是SUN的）
  关于查找算法中的二分法查找
      10（下标0） 11 12 13 14 15 16 17 18 19 20（下标10）
      通过二分法查找，找出18这个元素的下标：
          （0+10）/2-->中间元素的下标：5

          拿着中间这个元素和目标要查找的元素进行对比：
             中间元素是：arr[5] -- > 15
             15<18（被查找的元素）
                被查找的元素18在目前中间元素15的右边
                所以开始元素的下标从0变成5+1=6
          再重新计算一个中间元素的下标：
             开始下标是5+1
             结束下标是：10
             （6+10）/2  -->8
              8下面对应的元素arr[8]是18
                 找到的中间元素正好和被找的元素18相等，表示找到了：下标为8

       二分法查找的终止条件：一直折半，直到中间那个元素恰好是被查找的元素
  二分法查找基于排序的基础之上（没有排序的数据是无法查找的）

 */
public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = {100,200,230,235,600,1000,2000,9999};
        //找出arr这个数组中200所在的下标
        //调用方法
        int index = binarySearch(arr,200);
        System.out.println(index == -1 ? "该元素不存在！" : "该元素下标：" + index);
    }

    /**
     * 从数组中查找目标元素下标
     * @param arr  被查找的数组（这个必须是已经排序的）
     * @param dest 目标元素
     * @return -1表示该元素不存在，其他表示返回该元素的下标
     */
    private static int binarySearch(int[] arr, int dest) {
        //开始下标
        int begin = 0;
        //结束下标
        int end = arr.length - 1;

        while (begin <= end) {   //开始永远在结束的左边
            //中间元素下标
            int mid = (begin + end) / 2;
            if (arr[mid] == dest) {
                return mid;
            } else if (arr[mid] < dest) {
                //目标在中间的右边
                //开始元素下标需要发生变化
                begin = mid + 1;   //一直增
            } else {
                // arr[mid]>dest
                //目标在中间的左边
                //开始元素下标不用管，修改结束元素下标
                end = mid - 1;   //一直减
            }
        }
        return -1;
    }
}

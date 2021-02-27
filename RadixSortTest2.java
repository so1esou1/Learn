package com.csu.sort.radixsort;

import java.util.Arrays;

/*
    完整版基数排序
    基数排序会耗费额外的内存空间，数据量过大会报错OutOfMemoryError
    有负数的时候不要使用基数排序
 */
public class RadixSortTest2 {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort2(arr);
    }


    public static void radixSort2(int[] arr){
        //根据前面的推导过程得到最终的基数排序的代码
        //1、需要先得到数组中最大位数的个数
        int max = arr[0];       //先假设第一个是最大的
        for (int i = 1;i < arr.length;i ++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //得到最大位数:
        int maxLength = (max + "").length();            //巧妙的方式

        //依然定义好桶和桶指针
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        //2、使用循环处理:
        for (int i = 0,n = 1;i < maxLength;i ++,n *= 10){           //定义n，方便取位数
            //针对每个元素对应的为进行排序，第一次个位，第二次十位，第三次百位....
            for (int j = 0;j < arr.length;j ++){
                //取出每个元素的个位
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement] ++;
            }
            //按照桶的顺序(一维数组的下标依次取出数据，放到原来的数组)
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0;k < bucketElementCounts.length;k ++){
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0){
                    //循环该桶，即第k个桶，放入数据即可
                    for (int l = 0;l < bucketElementCounts[k];l ++){
                        //取出原数，放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后需要将每个bucketElementCounts[k]清零，这点很重要
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮，对个位的排序处理:");
            System.out.println(Arrays.toString(arr));       //[3, 14, 53, 214, 542, 748]
        }
    }
}

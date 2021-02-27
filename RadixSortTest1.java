package com.csu.sort.radixsort;

import java.util.Arrays;

/*
    基数排序代码实现
 */
public class RadixSortTest1 {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }


    //基数排序方法
    public static void radixSort(int[] arr){
        //按顺序渐进来

        //第1轮排序(针对每个元素的个位进行排序)

        //定义一个二维数组，表示10个桶，每个桶就是一个一位数组
        //说明：1、二维数组包含10个一维数组 2、为了防止在放数的时候数据溢出，则每个一维数组(桶)大小定位arr.length(很明显，桶/基数排序是使用空间换时间的经典算法)
        int[][] bucket = new int[10][arr.length];
        //每个桶都应该有一个指针指向当前放入的数据
        int[] bucketElementCounts = new int[10];
        for (int j = 0;j < arr.length;j ++){
            //取出每个元素的个位
            int digitOfElement = arr[j] / 1 % 10;
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
            //第1轮处理后需要将每个bucketElementCounts[k]清零，这点很重要
            bucketElementCounts[k] = 0;
        }
        System.out.println("第1轮，对个位的排序处理:");
        System.out.println(Arrays.toString(arr));       //[542, 53, 3, 14, 214, 748]



        //============================================================================
        //第2轮，针对每个元素的十位进行处理
        for (int j = 0;j < arr.length;j ++){
            //取出每个元素的十位
            int digitOfElement = arr[j] /10 % 10;               //这里除10再模10
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement] ++;
        }
        //按照桶的顺序(一维数组的下标依次取出数据，放到原来的数组)
        index = 0;
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
            //第2轮也要记得清零
            bucketElementCounts[k] = 0;
        }
        System.out.println("第2轮，对个位的排序处理:");
        System.out.println(Arrays.toString(arr));       //[3, 14, 214, 542, 748, 53]



        //============================================================================
        //第3轮，针对每个元素的百位进行处理
        for (int j = 0;j < arr.length;j ++){
            //取出每个元素的十位
            int digitOfElement = arr[j] /10 /10 % 10;               //这里除10再模10
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement] ++;
        }
        //按照桶的顺序(一维数组的下标依次取出数据，放到原来的数组)
        index = 0;
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
            //每一轮之后都要记得清零
            bucketElementCounts[k] = 0;
        }
        System.out.println("第3轮，对个位的排序处理:");
        System.out.println(Arrays.toString(arr));           //[3, 14, 53, 214, 542, 748]
    }
}



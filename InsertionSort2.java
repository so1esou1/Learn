package com.csu.sort.insertionsort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
    完整版插入排序
 */
public class InsertionSort2 {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        insertSort2(arr);


        //创建80000个随机数组，测试选择排序
        /*int[] array = new int[80000];
        for (int i = 0;i < 80000;i ++){
            array[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:" + dateStr);   //2021-02-24 16:40:10 492

        insertSort2(array);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:" + dateStr2);  //2021-02-24 16:40:11 274

         */


    }

    public static void insertSort2(int[] arr){
        int insertValue = 0;
        int insertIndex =0;
        for (int i = 1;i < arr.length;i ++){
            insertValue = arr[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            //在这里判断是否需要进行赋值
            if (insertValue + 1 != i){
                arr[insertIndex + 1] = insertValue;
            }

            System.out.println("第" + i + "轮插入后:");
            System.out.println(Arrays.toString(arr));
        }
    }
}

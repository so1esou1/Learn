package com.csu.sort.selectsort;
//完整版选择排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort2 {
    public static void main(String[] args) {
        int[] array = new int[]{101,34,119, 1};
        selectSort2(array);


        //创建80000个随机数组，测试选择排序
        /*int[] array = new int[80000];
        for (int i = 0;i < 80000;i ++){
            array[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:" + dateStr);           //2021-02-24 15:21:44

        selectSort2(array);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:" + dateStr2);          //2021-02-24 15:21:46

        //***选择排序的耗时比冒泡排序小很多*/
    }


    //完整的选择排序算法
    public static void selectSort2(int[] array){
        for (int i = 0;i < array.length - 1;i ++){          //length-1次
            int minIndex = i;
            int min = array[i];
            for (int j = i+1;j < array.length;j++){
                if (min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }
            System.out.println("第" + (i + 1) + "次排序的结果是:");
            System.out.println(Arrays.toString(array));
        }
    }
}

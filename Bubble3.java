package com.csu.sort.bubblesort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
    继续优化冒泡排序:如果我们发现在某趟排序中没有进行任何的交换，则可以提前结束
 */
public class Bubble3 {
    public static void main(String[] args) {
        int array[] = {3,9,-1,10,20};       //修改下数组

        bubbleSort(array);

        //以下是测试冒泡排序的时间
        //创建一个80000个数字的随机数组
        /*int array2[] = new int[80000];
        for (int i = 0;i < 80000;i ++){
            array2[i] = (int)(Math.random() * 8000000);     //会生成[0,8000000)的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:" + dateStr);       //2021-02-24 14:31:47

        bubbleSort(array2);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:" + dateStr2);      //2021-02-24 14:31:59*/
    }


    //将前面的冒泡排序封装成一个方法
    public static void bubbleSort(int[] array){
        int temp = 0;
        //设置一个表示变量，表示是否进行过交换
        boolean flag = false;
        for (int i = 0;i < array.length - 1;i ++){
            for (int j = 0;j < array.length - 1 - i;j ++){
                if (array[j] > array[j + 1]){
                    flag = true;        //进来过之后标识变量变成true
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "趟排序后的数组：");
            System.out.println(Arrays.toString(array));
            System.out.println(flag);
            if (!flag){         //在一趟排序中一次交换都没有发生
                break;
            }else {
                flag = false;       //重置flag，进行下一次判断
            }

        }
    }
}

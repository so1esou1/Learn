package com.bjpowernode.javase.array;
/*
二维数组的遍历
 */
public class ArrayTest11 {
    public static void main(String[] args) {

        //二维数组
        String[][] array = {
                {"java","oracle","c++","python","c#"},
                {"张三","李四","王五"},
                {"lucy","jack","rose"},
        };
        //遍历二维数组
        for (int i = 0 ;i < array.length;i++){   //外层循环三次（负责纵向的）
            String[] 一维数组 = array[i];
            //负责遍历一维数组
            for (int j = 0;j < 一维数组.length;j ++){
                System.out.print(一维数组[j] + "");
            }
            //输出换行符
            System.out.println();
        }
        //合并代码
        for (int i = 0 ;i < array.length;i++){
            for (int j = 0;j < array[i].length;j ++){
                System.out.print(array[i][j] + "");
            }
            //输出换行符
            System.out.println();
        }



    }
}

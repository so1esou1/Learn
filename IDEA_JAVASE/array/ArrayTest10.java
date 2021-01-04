package com.bjpowernode.javase.array;
/*
关于二维数组中元素的读和改
     a[二维数组中的一维数组的下标][一维数组的下标]
     a[0][0]表示第一个一维数组中的第一个元素
     a[3][100]表示第四个一维数组中的第101个元素，其中，a[3]是一个整体，[100]是前面a[3]执行结束的结果再下标100

    改：a[?][?] = ?????

 */
public class ArrayTest10 {
    public static void main(String[] args) {
        int[][] a = {
                {34,4,65},
                {100,200,3900,111},
                {0},
        };

        //取出第1个一维数组
        int[] 我是第一个一维数组 = a[0];    //[]代表第一个一维数组
        int 我是第一个一维数组中的第一个元素 = 我是第一个一维数组[0];
        System.out.println(我是第一个一维数组中的第一个元素);     //34

        //合并以上代码，以下代码的由来是以上代码合并导致的
        System.out.println(a[0][0]);

        //取出第二个一维数组第三个元素
        System.out.println(a[1][2]);

        //改
        a[2][0] = 11111;
        System.out.println(a[2][0]);
    }
}

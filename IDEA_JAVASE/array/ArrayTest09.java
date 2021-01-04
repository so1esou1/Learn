package com.bjpowernode.javase.array;
/*关于二维数组：
    1、二维数组其实是一个特殊的一维数组，特殊在一维数组当中每个元素是一个一维数组
    2、三位数组是一个特殊的二维数组,特殊在这个二维数组中每个元素是一个一维数组
    3、二维数组静态初始化：
    int[][] array = {{1,1,1},{2,3,4,5},{0,0,0,0}};
 */
public class ArrayTest09 {
    public static void main(String[] args) {
        //一维数组
        int[] array = {100,200,300};
        System.out.println(array.length); //3

        //二维数组,里面是4个一维数组
        int[][] a = {
                {100,200,300},
                {30,20,40,50,60},
                {6,7,9,1},
                {0},
        };
        System.out.println(a.length);  //4
        System.out.println(a[0].length);  //3
        System.out.println(a[1].length);  //5
        System.out.println(a[2].length);   //4
        System.out.println(a[3].length);  //1

    }
}

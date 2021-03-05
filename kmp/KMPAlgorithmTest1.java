package com.csu.kmp.kmp;

import java.util.Arrays;

/*
    KMP算法代码实现
 */
public class KMPAlgorithmTest1 {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] suit = kmpNext("ABCDABD");
        System.out.println(Arrays.toString(suit));      //[0, 0, 0, 0, 1, 2, 0]

        //测试kmp算法
        int index = kmpSearch(str1,str2,suit);
        System.out.println("index=" + index);           //15
    }

    //先写一个方法---获取到字符串(子串)的部分匹配值
    public static int[] kmpNext(String dest){
        //创建一个数组保存部分匹配值，与dest长度相等
        int[] suit = new int[dest.length()];
        suit[0] = 0;        //如果字符串长度为1，部分匹配值就是0
        for (int i = 1,j = 0;i < dest.length();i ++){       //从第2个开始匹配
            //当这两个不等的时候，我们需要从suit[j-1]获取新的j，直到我们发现有相等条件时才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = suit[j - 1];
            }
            //如果匹配成功，去匹配的字符串的指针j往后移一位
            if (dest.charAt(i) == dest.charAt(j)){
                j ++;
            }
            suit[i] = j;
        }
        return suit;
    }


    //写出KMP搜索算法:
    /**
     *
     * @param str1  原字符串
     * @param str2  来匹配的字符串，子串
     * @param suit  子串对应的部分匹配表
     * @return      返回第一个匹配的位置，没有匹配到就返回-1
     */
    public static int kmpSearch(String str1,String str2,int[] suit){
        //遍历str1
        for (int i = 0,j = 0;i < str1.length();i++){
            //需要考虑当str1.charAt(i) == str2.charAt(j)不相等时的情况，去调整j的大小
            //KMP算法的核心点
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = suit[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j ++;
            }
            if (j == str2.length()){    //找到了
                //返回下标
                return i -j + 1;
            }
        }
        return -1;
    }
}

package com.csu.kmp.violencematch;
/*
    暴力匹配字符串代码实现
 */
public class ViolenceMatchTest1 {
    public static void main(String[] args) {
        //测试暴力匹配算法
        String str1 = "埋骨何须桑梓地，人生何处不青山";
        String str2 = "人生何处";
        int index = violenceMatch(str1,str2);
        System.out.println(index);          //8
    }


    //暴力匹配算法实现
    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();         //转成char数组
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;      //s1的长度
        int s2Len = s2.length;

        int i = 0;
        int j = 0;          //i、j都是索引，i指向s1，j指向s2
        while (i < s1Len && j < s2Len){     //保证匹配时不越界
            if (s1[i] == s2[j]){        //两个字符匹配成功
                i ++;
                j ++;
            }else {
                //没有匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == s2Len){            //j的长度和s2相同了
            return i - j;
        }else {
            return -1;
        }
    }
}

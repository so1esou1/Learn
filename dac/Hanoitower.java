package com.csu.dac;
/*
    分治法解决汉诺塔问题的代码实现
 */
public class Hanoitower {
    public static void main(String[] args) {
        //hanoitower(1,'A','B','C');
        //hanoitower(2,'A','B','C');
        hanoitower(64,'A','B','C');
    }


    //汉诺塔的移动方案
    public static void hanoitower(int num,char a,char b,char c){        //abc是三个塔
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从 " + a + "->" + c);
        }else {
            //如果 num >= 2 情况，我们总是可以看做是两个盘
            //1、先把最上面的盘a->b
            hanoitower(num - 1,a,c,b);          //移动过程:移动过程会使用到b
            //2、把最下面的盘a->c
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3、把b塔的所有盘移动到c
            hanoitower(num - 1,b,a,c);          //移动过程使用到a塔
        }
    }
}

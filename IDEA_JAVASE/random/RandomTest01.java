package com.bjpowernode.javase.random;

import java.util.Random;

/*
随机数
 */
public class RandomTest01 {
    public static void main(String[] args) {
        Random random = new Random();
        int num1 = random.nextInt();
        System.out.println(num1);//产生的是随机数，int范围内的数字

        //产生0-100之间的随机数，不能产生101
        //nextInt翻译为下一个int类型的数据是101，表示只能取到100
        int num2 = random.nextInt(101);//不包括101
        System.out.println(num2);
    }
}

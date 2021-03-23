package com.csu.jvm;

import java.util.Random;

/**
 * @author so1esou1
 * @ClassName   模拟堆溢出
 * @Date 2021.1.4
 * @TODO
 */
public class HeapTest1 {
    public static void main(String[] args) {
        String str = "asdqwqd";
        while (true){
            str += new Random().nextInt(21231212)+new Random().nextInt(21231212);
        }
        //会出现OOM错误
    }
}

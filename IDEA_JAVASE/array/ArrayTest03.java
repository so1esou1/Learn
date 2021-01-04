package com.bjpowernode.javase.array;

public class ArrayTest03 {
    public static void main(String args[]) {  //main方法的编写格式也可以采用C++的编写格式

        //调用方法时传一个数组
        int[] x = {1,2,3,4,};
        printArray(x);

        //创建String数组
        String[] stringArray= {"abc","def","hehe","haha"};
        printArray(stringArray);

        String[] strArray = new String[10];
        printArray(strArray);  //10个null

        System.out.println("=======================");
        printArray(new String[3]);//3个null
        System.out.println("*************************");
        printArray(new int[4]);//4个0
    }
    public static void printArray(int[] array){
        for (int i = 0;i < array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void printArray(String[] args){
        for (int i = 0;i < args.length;i++){
            System.out.println("String数组中的元素" + args[i]);
        }
    }
}

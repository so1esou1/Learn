package com.bjpowernode.javase.random;

import java.util.Arrays;
import java.util.Random;

/*作业：
编写程序，生成5个不重复的随机数[0-100]，重复的话重新生成
最终生成的5个随机数放到数组中
 */
public class RandomTest02 {
    public static void main(String[] args) {
        //创建random对象
        Random random = new Random();
        //首先准备一个长度为5的一维数组
        int[] arr = new int[5];  //默认值都是0
        for (int i = 0;i < arr.length;i ++){
            arr[i] = -1;
        }
        //循环，生成随机数
        int index = 0;
        while(index < arr.length){    //下标小于4的适合就结束
            //生成随机数
            //int num = random.nextInt(101);不要1-100，1-100太大了，直接1-5来快速检验
            int num = random.nextInt(6);
            //int num = random.nextInt(4);只有0到3这4个数，永远凑不满5个的数组，是死循环
            //判断arr数组中有没有这个num
            //如果没有这个num，就放进去
            if (!contains(arr,num)){   //方法见下
                arr[index] = num;
                index ++;
            }
        }
        //循环结束后遍历以上数组
        for (int i = 0;i < arr.length;i ++){
            System.out.println(arr[i]);//-1 -1 6 56 55为什么又两个-1？？是因为排序出问题了
        }
    }


    /**
     * 单独编写一个方法，这个方法专门用来判断数组中是否包含某个元素
     * @param arr 数组
     * @param key 元素
     * @return true表示包含，false表示不包含
     */
    public static boolean contains(int[] arr,int key){
        /*//对数组进行升序   这个方法排序有问题
        Arrays.sort(arr);
        //进行二分法查找
        //二分法查找的结果 》= 0说明这个元素找到了，找到了表示存在
        return Arrays.binarySearch(arr,key) >= 0;
        */
        for (int i = 0;i < arr.length;i ++){
            if (arr[i] == key){
                //条件成立了表示包含，返回true
                return true;
            }
        }
        //表示不包含
        return false;
    }
}

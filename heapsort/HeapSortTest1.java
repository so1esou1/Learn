package com.csu.tree.heapsort;

import java.util.Arrays;

/*
    堆排序代码实现
 */
public class HeapSortTest1 {
    public static void main(String[] args) {
        //要求:将数组进行升序排序
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }


    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序");

        //分步完成
        /*adjustHeap(arr,1, arr.length);          //第一次传入的是1和数组大小
        System.out.println("第一次" + Arrays.toString(arr));       //4,9,8,5,6

        adjustHeap(arr,0, arr.length);
        System.out.println("第二次" + Arrays.toString(arr));       //9,6,8,5,4
         */

        //一次性实现:
        //(1)将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆；
        for (int i = arr.length/2-1;i >= 0;i --){
            adjustHeap(arr,i, arr.length);
        }
        //(2)将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端；
        //(3)重新调整结构，使其满足堆定义，然后交换堆顶元素与其末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j = arr.length-1;j > 0;j ++){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }

        System.out.println("数组=" + Arrays.toString(arr));
    }


    //将一个数组(二叉树)调整成一个大顶堆        (从左至右，从下至上调整)
    /**
     *  功能：完成将以i对应的非叶子结点的树调整成大顶堆
     *
     * @param arr   待调整的数组
     * @param i     非叶子结点在数组中的索引
     * @param length    对多少个元素进行调整,length是在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];          //先取出当前元素的值，保存到一个临时变量
        //开始调整
        for (int k = i * 2 + 1;k < length;k = k * 2 + 1){       //说明:k指向的i结点的左子结点
            if (k+1<length && arr[k]<arr[k+1]){           //说明右子结点没有越界+这个左子结点的值<右子结点的值
                k ++;                       //让k指向右子结点
            }
            if (arr[k] > temp){             //如果右子节点>父节点
                arr[i] = arr[k];         //把较大的值赋给当前这个结点
                i = k;                      //i指向k，继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，已经将以i为父节点的树的最大值，放在了最顶上(局部)
        arr[i] = temp;      //将temp值放在调整后的位置
    }
}



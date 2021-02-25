package com.csu.sort.mergesort;

import java.util.Arrays;

/*
    归并排序
 */
public class MergedSort1 {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];       //归并排序需要一个额外的空间
        mergeSort(arr,0, arr.length-1,temp);

        System.out.println("归并排序后=" + Arrays.toString(arr));
    }


    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;       //中间的索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);        //mid之后成为下一次递归的right
            //向右递归进行分解
            mergeSort(arr,mid+1, right, temp);      //mid+1成为下一次递归的left

            //每到合并时就
            merge(arr,left,mid,right,temp);
        }
    }


    /**
     * 一、合并的方法
     * @param arr 参与排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right   右边索引
     * @param temp  做中转的临时数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        System.out.println("----------------");
        int i = left;       //初始化i，左边有序序列的初始索引
        int j = mid + 1;    //初始化j，右边有序序列的初始化索引
        int t = 0;          //指向temp数组的当前索引

        //(1)先把左右两边(有序)的数据按照规则填充到temp数组
        //知道左右两边的有序序列，有一半处理完毕为止
        while (i <= mid && j <=right){      //说明还没有排好，继续排
            //如果左边的有序序列的当前元素<=右边的有序序列的当前元素
            //即将左边的当前元素拷贝到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }
            else {      //反之，左边>右边,则把右放到temp
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //(2)把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid){       //成立则说明左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right){       //成立则说明右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //(3)将temp数组的元素拷贝回arr数组
        //注意:并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft="+ tempLeft + "right=" + right);
        while (tempLeft <= right){
            //第一次拷贝的时候会发现tempLeft=0,right=1;第二次tempLeft=2,right=3;第三次tL=0,ri=3;最后一次第七次才是tL=0,ri=7
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}

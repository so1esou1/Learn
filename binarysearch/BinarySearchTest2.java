package com.csu.search.binarysearch;

import java.util.ArrayList;
import java.util.List;

/*
完善上一个二分法查找:有多个相同的数值时，如何将所有的数值都查找到？
    思路：1、再找到mid索引值时，不要马上返回
         2、向mid这个索引值的左边扫描，将满足要查找值的下标加入到一个集合中ArrayList中
         3、向mid的索引值的右边扫描，将所有满足要查找值的下标也加入到ArrayList中
         4、将这个集合返回
 */
public class BinarySearchTest2 {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1234};
        List<Integer> resIndexList =  binarySearch2(arr,0, arr.length - 1,1000);
        System.out.println(resIndexList);
    }


    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value){
        if (left > right){
            return new ArrayList<Integer>();        //返回一个空的arraylist集合
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (value > midValue){
            return binarySearch2(arr,mid+1,right,value);
        }else if (value < midValue){
            return binarySearch2(arr,left,mid-1,value);
        }else {
            //创建arraylist
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向左边扫描
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != value){        //说明左边没扫描到，可以退出了
                    break;
                }
                //否则将这个temp放入到集合resIndexList中
                resIndexList.add(temp);
                temp -= 1;      //temp左移
            }
            resIndexList.add(mid);

            //向mid索引值的右边扫描,与左边类似
            temp = mid + 1;
            while (true){
                if (temp >arr.length - 1 || arr[temp] != value){        //说明右边没扫描到，可以退出了
                    break;
                }
                //否则将这个temp放入到集合resIndexList中
                resIndexList.add(temp);
                temp += 1;      //temp右移
            }
            return resIndexList;
        }
    }
}

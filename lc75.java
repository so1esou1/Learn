package com.csu.wuyitoyibai;

//力扣75 颜色分类
public class lc75 {
    class Solution {
        public void sortColors(int[] nums) {
            //常规方法可以使用各种排序算法

            //使用三指针方法:
            int p0 = 0;
            int p2 = nums.length-1;
            int p = 0;
            while (p <= p2){
                if (nums[p] == 2){
                    swap(nums,p,p2);
                    p2--;
                }else if (nums[p] == 0){
                    swap(nums,p,p0);
                    p++;
                    p0++;
                }else{
                    p++;
                }
            }
        }
        public void swap(int[] nums,int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}

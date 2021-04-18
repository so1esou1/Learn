package com.csu.yitosanshi;

//力扣27 移除元素
public class lc27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            if(nums.length == 0){
                return 0;
            }
            int size = nums.length;
            int index = nums.length - 1;
            for(int i = 0;i < nums.length;i ++){
                while(nums[i] == val && index >= i){
                    size --;
                    swap(nums,i,index);
                    index --;
                }
            }
            return size;
        }
        public void swap(int a[],int x,int y){
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
        }
    }
}

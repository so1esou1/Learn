package com.csu.wuyitoyibai;

//力扣80 删除有序数组中的重复项 II
public class lc80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length <= 2) return nums.length;
            int start = 2;  //初始下标
            for(int i = 2; i < nums.length; i++)//如果i下标的数字和初始前两个的相同则跳过，否则赋给初始
                if(nums[i] != nums[start - 2])
                    nums[start++] = nums[i];
            return start;


            //双指针:快指针遍历整个数组，慢指针为修改后数组的长度
        /*int fast = 2;
        int slow = 1;
        for(; fast < nums.length ;fast++){
            if(nums[slow-1] != nums[fast]){
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
        */
        }
    }
}

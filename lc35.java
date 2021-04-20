package com.csu.yitosanshi;

//力扣35 搜索插入位置
public class lc35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}

package com.csu.wuyitoyibai;

//力扣53 最大子序和
public class lc53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            //动态规划:
            int n = nums.length;
            int dp = nums[0];
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                if (dp < 0) {
                    dp = nums[i];
                } else {
                    dp= dp + nums[i];
                }
                max = Math.max(max, dp);
            }
            return max;
        }
    }
}

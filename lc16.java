package com.csu.yitosanshi;

import java.util.Arrays;

//力扣17 最接近的三数之和
public class lc16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int sum = 0;
            int len = nums.length;
            if (len == 3) {
                return nums[0] + nums[1] + nums[2];
            }
            Arrays.sort(nums);
            int start = 0;
            int end = len - 1;
            double sub = Integer.MAX_VALUE;
            int fixIndex = 0;
            for (int i = 0; i < len-2; i++) {
                fixIndex = i;
                start=i+1;
                end=len-1;
                while (start < end) {
                    sum = nums[start] + nums[fixIndex] + nums[end] - target;
                    if (sum == 0) {
                        return target;
                    }
                    sub = Math.abs(sub) > Math.abs(sum) ? sum : sub;
                    if (sum > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return (int) (target + sub);
        }
    }
}

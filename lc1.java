package com.csu.yitosanshi;

//力扣第一题，两数之和
public class lc1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {


            for(int i = 0;i < nums.length - 1;i ++){
                for(int j = i + 1;j < nums.length;j ++){

                    if(nums[i] + nums[j] == target){
                        int[] arr = {i,j};
                        return arr;
                    }

                }
            }
            return new int[0];
        }
    }
}

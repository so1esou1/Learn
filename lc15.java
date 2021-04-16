package com.csu.yitosanshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//力扣15 三数之和
public class lc15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0;i < nums.length - 2;i ++){
                if(nums[i] > 0){
                    break;
                };
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum < 0){
                        while(j < k && nums[j] == nums[++j]);
                    }else if(sum > 0){
                        while(j < k && nums[k] == nums[--k]);
                    }else{
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                        while(j < k && nums[j] == nums[++j]);
                        while(j < k && nums[k] == nums[--k]);
                    }
                }
            }
            return res;
        }
    }
}

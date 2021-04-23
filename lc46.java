package com.csu.yitosanshi;

import java.util.ArrayList;
import java.util.List;

//力扣46 全排列
public class lc46 {
    class Solution {
        //回溯算法
        List<List<Integer>> listList;
        public List<List<Integer>> permute(int[] nums) {


            listList = new ArrayList<>();
            permute(nums, new ArrayList<>());
            return listList;




        }
        private void permute(int[] nums, List<Integer> list) {
            int n = nums.length;
            if(list.size() == n) {
                listList.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < n; i++) {
                if(list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                permute(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

package com.csu.yitosanshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//力扣40 组合总和2
public class lc40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates); //排序
            getAnswer(ans, new ArrayList<>(), candidates, target, 0);
            return ans;
        }

        private void getAnswer(List<List<Integer>> ans, ArrayList<Integer> temp, int[] candidates, int target, int start) {
            if (target == 0) {
                ans.add(new ArrayList<Integer>(temp));
            } else if (target < 0) {
                return;
            } else {
                for (int i = start; i < candidates.length; i++) {
                    //跳过重复的数字
                    if(i > start && candidates[i] == candidates[i-1]) continue;
                    temp.add(candidates[i]);
                    /*************修改的地方*******************/
                    //i -> i + 1 ，因为每个数字只能用一次，所以下次遍历的时候不从自己开始
                    getAnswer(ans, temp, candidates, target - candidates[i], i + 1);
                    /****************************************/
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}

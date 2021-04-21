package com.csu.yitosanshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//力扣39 组合总和
public class lc39 {
    class Solution {
        //回溯剪枝
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List ret = new ArrayList();
            Arrays.sort(candidates);
            int length = candidates.length;
            if (length == 0){
                return ret;
            }
            Stack temp = new Stack();
            findComplexSum(ret,candidates,target, 0, temp);
            return ret;
        }
        public void findComplexSum(List ret, int[] candidates,
                                   int residue, int start, Stack temp){
            if (residue == 0) {
                ret.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start;i<candidates.length&&residue-candidates[i] >=0 ; i++) {
                temp.add(candidates[i]);
                findComplexSum(ret,candidates,residue - candidates[i],i,temp);
                temp.pop();
            }
        }

    }
}

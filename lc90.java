package com.csu.wuyitoyibai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//力扣90 子集 II
public class lc90 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //递归，深度优先遍历

            // 从小到大排序
            Arrays.sort(nums);
            // 最终结果
            List<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>());
            // 回溯
            dfs(0, nums, new Stack<>(), result);

            return result;
        }

        public void dfs(int index, int[] nums, Stack<Integer> stack, List<List<Integer>> result) {
            if (index >= nums.length) {
                return;
            }

            for (int i = index; i < nums.length; i ++ ) {
                // 在这一次总的查找中，如果当前节点和上一个节点相同，则跳过
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 添加该数
                stack.push(nums[i]);
                // 作为一种情况，放进结果中
                result.add(new LinkedList<>(stack));
                // 继续回溯
                dfs(i  + 1, nums, stack, result);
                // 回退
                stack.pop();
            }
        }
    }
}

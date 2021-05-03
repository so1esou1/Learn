package com.csu.wuyitoyibai;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//力扣77 组合
public class lc77 {
    class Solution {
        //简单的方法:遍历递归获取，利用一个 stack 存储中间结果，不断进行出栈入栈

        //回溯剪枝的方式:
        //优化，减少回溯中不需要的情况：
        public List<List<Integer>> combine(int n, int k) {

            if (k == 0) {
                return new LinkedList<>();
            }
            if (n == 0) {
                return new LinkedList<>();
            }

            List<List<Integer>> result = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            dfs(n, k, 1, stack, result);

            return result;
        }
        public void dfs(int n, int remain, int index, Stack<Integer> stack, List<List<Integer>> result) {
            // 当剩余没有遍历的数，比还需要遍遍历的数少时，也可以不用继续了。
            for (int i = index; i <= n && (n - i + 1 >= remain); i++) {
                // 加入stack中
                stack.push(i);
                // 是否加到k个数
                if (remain - 1 == 0) {
                    result.add(new LinkedList<>(stack));
                } else {
                    dfs(n, remain - 1, i + 1, stack, result);
                }
                stack.pop();
            }
        }
    }
}

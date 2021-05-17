package com.csu.yilingyiToyibaiwu;


//力扣113 路径总和 II
public class lc113 {
    public static void main(String[] args) {
        class Solution {
            //和上题类似，这里我们使用广度优先试试
            List<List<Integer>> ret = new LinkedList<List<Integer>>();
            Deque<Integer> path = new LinkedList<Integer>();


            public List<List<Integer>> pathSum(TreeNode root, int sum) {
                dfs(root, sum);
                return ret;

            }
            //枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径
            public void dfs(TreeNode root, int sum) {
                if (root == null) {
                    return;
                }
                path.offerLast(root.val);
                sum -= root.val;
                if (root.left == null && root.right == null && sum == 0) {
                    ret.add(new LinkedList<Integer>(path));
                }
                dfs(root.left, sum);
                dfs(root.right, sum);
                path.pollLast();
            }
        }
    }
}

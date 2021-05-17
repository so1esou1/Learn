package com.csu.yilingyiToyibaiwu;

//力扣112题 路径总和
public class lc112 {
    public static void main(String[] args) {
        class Solution {
            public boolean hasPathSum(TreeNode root, int sum) {
        /*
            使用广度优先搜索的方式，记录从根节点到当前节点的路径和，以防止重复计算。
            这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
        */
                if (root == null) {
                    return false;
                }
                Queue<TreeNode> queNode = new LinkedList<TreeNode>();
                Queue<Integer> queVal = new LinkedList<Integer>();
                queNode.offer(root);
                queVal.offer(root.val);
                while (!queNode.isEmpty()) {
                    TreeNode now = queNode.poll();
                    int temp = queVal.poll();
                    if (now.left == null && now.right == null) {
                        if (temp == sum) {
                            return true;
                        }
                        continue;
                    }
                    if (now.left != null) {
                        queNode.offer(now.left);
                        queVal.offer(now.left.val + temp);
                    }
                    if (now.right != null) {
                        queNode.offer(now.right);
                        queVal.offer(now.right.val + temp);
                    }
                }
                return false;



                //递归的方式:
        /*if(root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        */

            }
        }
    }
}

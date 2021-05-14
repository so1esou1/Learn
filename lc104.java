package com.csu.yilingyiToyibaiwu;

//力扣104 二叉树的最大深度
public class lc104 {
    public static void main(String[] args) {
        class Solution {
            public int maxDepth(TreeNode root) {
                //递归两行代码,这种解法值得学习:
                if(root == null) return 0;
                return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            }
        }
    }
}

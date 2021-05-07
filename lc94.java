package com.csu.wuyitoyibai;

import javax.swing.tree.TreeNode;
import java.util.List;

//力扣94 二叉树的中序遍历
public class lc94 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            //正常使用递归的方式:
            List<Integer> ans = new ArrayList<>();
            inorder(root, ans);
            return ans;

        /*使用栈数据结构，不使用递归的方法:
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet();
        List<Integer> res = new ArrayList();
        if(root == null)
            return res;

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            while(cur.left != null && !set.contains(cur.left)) {
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            set.add(cur);
            if(cur.right != null)
                stack.push(cur.right);
        }

        return res;

        */
        }
        public void inorder(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
        }
    }
}

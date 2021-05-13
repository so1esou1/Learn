package com.csu.yilingyiToyibaiwu;

//力扣101 对称二叉树
public class lc101 {
    public static void main(String[] args) {
        class Solution {
            public boolean isSymmetric(TreeNode root) {
        /*
            实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，pp 指针和 qq 指针一开始都指向这棵树的根，随后 pp 右移时，qq 左移，pp 左移时，qq 右移。每次检查当前 pp 和 qq 节点的值是否相等，如果相等再判断左右子树是否对称。
        */

                return check(root,root);
            }

            public boolean check(TreeNode p, TreeNode q) {
                if (p == null && q == null) {
                    return true;
                }
                if (p == null || q == null) {
                    return false;
                }
                return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
            }

        }
    }
}

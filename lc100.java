package com.csu.wuyitoyibai;

//力扣100 相同的树
public class lc100 {
    public static void main(String[] args) {
        class Solution {
            public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
        当满足终止条件时进行返回，不满足时分别判断左子树和右子树是否相同，其中要注意代码中的短路效应
        */
                if(p == null && q == null)
                    return true;
                if(p == null || q == null)
                    return false;
                if(p.val != q.val)
                    return false;
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

            }
        }
    }
}

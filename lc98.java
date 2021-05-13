package com.csu.wuyitoyibai;

import javax.swing.tree.TreeNode;

//力扣98 验证二叉搜索树
public class lc98 {
    public static void main(String[] args) {
        class Solution {
            TreeNode prev;     //给中序遍历定义的全局变量
            public boolean isValidBST(TreeNode root) {
                //1、使用递归回溯的思想，把二叉树分成一个个左右子树进行判断,速度可行
                /*return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);*/


                //2、中序遍历的方式，这个速度可行:
                if (root == null)
                    return true;
                //访问左子树
                if (!isValidBST(root.left))
                    return false;
                //访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false。
                if (prev != null && prev.val >= root.val)
                    return false;
                prev = root;
                //访问右子树
                if (!isValidBST(root.right))
                    return false;
                return true;
            }




    /*
    if (root == null)
        return true;
    //每个节点如果超过这个范围，直接返回false
    if (root.val >= maxVal || root.val <= minVal)
        return false;
    //这里再分别以左右两个子节点分别判断，
    //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
    //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
    return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);     */
        }
    }
}

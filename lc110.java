package com.csu.yilingyiToyibaiwu;


//力扣110 平衡二叉树
public class lc110 {
    public static void main(String[] args) {
        class Solution {
        /*
            自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1−1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
        进一步优化:只要左子树为-1了，就不需要再递归右子树了，直接返回-1就可以了
        */

            //这种解法有点看不懂，速度还行
            public boolean isBalanced(TreeNode root) {
                return balanced(root) != -1;
            }

            private int balanced(TreeNode node) {
                if (node == null){
                    return 0;
                }
                int leftHeight, rightHeight;
                if ((leftHeight = balanced(node.left)) == -1
                        || (rightHeight = balanced(node.right)) == -1
                        || Math.abs(leftHeight - rightHeight) > 1)
                    return -1;
                return Math.max(leftHeight, rightHeight) + 1;   //应该是这里算出高度差的
            }
        }
    }
}

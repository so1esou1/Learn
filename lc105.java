package com.csu.yilingyiToyibaiwu;

//力扣105 从前序与中序遍历序列构造二叉树(剑指原题)
public class lc105 {
    public static void main(String[] args) {
        class Solution {
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                //这道题剑指Offer中也有,面试题7，那个讲解更仔细，建议使用书上的方法

                return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
            }

            private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
                // preorder 为空，直接返回 null
                if (p_start == p_end) {
                    return null;
                }
                int root_val = preorder[p_start];
                TreeNode root = new TreeNode(root_val);
                //在中序遍历中找到根节点的位置
                int i_root_index = 0;
                for (int i = i_start; i < i_end; i++) {
                    if (root_val == inorder[i]) {
                        i_root_index = i;
                        break;
                    }
                }
                int leftNum = i_root_index - i_start;
                //递归的构造左子树
                root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
                //递归的构造右子树
                root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
                return root;
            }

        }
    }
}

package com.csu.yilingyiToyibaiwu;

//力扣106 从中序与后序遍历序列构造二叉树
public class lc106 {
    public static void main(String[] args) {
        class Solution {
            //HashMap memo 需要一个哈希表来保存中序遍历序列中,元素和索引的位置关系.因为从后序序列中拿到根节点后，要在中序序列中查找对应的位置,从而将数组分为左子树和右子树:
            HashMap<Integer,Integer> memo = new HashMap<>();
            int[] post;

            public TreeNode buildTree(int[] inorder, int[] postorder) {
                //在后序遍历序列中,最后一个元素为树的根节点

        /*
            思路(跟上一题差不太多):
                首先在后序遍历序列中找到根节点(最后一个元素)
                根据根节点在中序遍历序列中找到根节点的位置
                根据根节点的位置将中序遍历序列分为左子树和右子树
                根据根节点的位置确定左子树和右子树在中序数组和后续数组中的左右边界位置
                递归构造左子树和右子树
                返回根节点结束
        */
                for(int i = 0;i < inorder.length; i++)
                    memo.put(inorder[i], i);
                post = postorder;
                TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
                return root;

            }

            public TreeNode buildTree(int is, int ie, int ps, int pe) { //参数为，中序遍历中，左子树起始、结束坐标和右子树起始、结束坐标
                if(ie < is || pe < ps) return null;

                int root = post[pe];
                int ri = memo.get(root);

                TreeNode node = new TreeNode(root);
                node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
                node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
                return node;
            }
        }
    }
}

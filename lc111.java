package com.csu.yilingyiToyibaiwu;


//力扣111 二叉树的最小深度
public class lc111 {
    public static void main(String[] args) {
        class Solution {
            public int minDepth(TreeNode root) {

                //方法一:深度优先搜索，速度不行
        /*if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);   //向左子树递归
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);  //向右子树递归
        }

        return min_depth + 1;
        */



                //方法二：广度优先搜索,这个速度还行:
                //当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
                if (root == null) {
                    return 0;
                }

                Queue<QueueNode> queue = new LinkedList<QueueNode>();
                queue.offer(new QueueNode(root, 1));
                while (!queue.isEmpty()) {
                    QueueNode nodeDepth = queue.poll();     //最深的结点
                    TreeNode node = nodeDepth.node;
                    int depth = nodeDepth.depth;
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        queue.offer(new QueueNode(node.left, depth + 1));
                    }
                    if (node.right != null) {
                        queue.offer(new QueueNode(node.right, depth + 1));
                    }
                }

                return 0;
            }


            class QueueNode {
                TreeNode node;
                int depth;

                public QueueNode(TreeNode node, int depth) {
                    this.node = node;
                    this.depth = depth;
                }
            }
        }
    }
}

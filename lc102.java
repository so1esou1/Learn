package com.csu.yilingyiToyibaiwu;

//力扣102 二叉树的层序遍历
public class lc102 {
    public static void main(String[] args) {
        class Solution {
            public List<List<Integer>> levelOrder(TreeNode root) {

        /*
            1、广度优先遍历是按层层推进的方式，遍历每一层的节点。题目要求的是返回每一层的节点值，所以这题用广度优先来做非常合适。
广度优先需要用队列作为辅助结构，我们先将根节点放到队列中，然后不断遍历队列。
    速度可行

        */
                if(root==null) {
                    return new ArrayList<List<Integer>>();
                }

                List<List<Integer>> res = new ArrayList<List<Integer>>();
                LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
                //将根节点放入队列中，然后不断遍历队列
                queue.add(root);
                while(queue.size()>0) {
                    //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
                    int size = queue.size();
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
                    //如果节点的左/右子树不为空，也放入队列中
                    for(int i=0;i<size;++i) {
                        TreeNode t = queue.remove();
                        tmp.add(t.val);
                        if(t.left!=null) {
                            queue.add(t.left);
                        }
                        if(t.right!=null) {
                            queue.add(t.right);
                        }
                    }
                    //将临时list加入最终返回结果中
                    res.add(tmp);
                }
                return res;



        /*
        2、深度优先DFS:
        因为每层的节点值要分开记录，所以递归的参数除了节点node以外还需要当前层数level
        如果节点已为空，return，结束当前递归分支即可
        如果res的长度已经和当前层数level相等，说明res需要多加个位置了，因为level是res数组的索引，索引是一定比长度要小的，如果相等说明数组长度不够长了，得扩容
        把当前节点加到对应层的数组中去res[level].append(node.val)
        继续依次遍历左右字节点，层数level + 1
        返回res

        */

        /*
        List<List<Integer>> res;
        public List<List<Integer>> levelOrder(TreeNode root) {
            res = new ArrayList<>();
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode node, int level){
            if(node == null) return;
            if(res.size() == level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }
        */

            }
        }
    }
}

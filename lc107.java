package com.csu.yilingyiToyibaiwu;

//力扣107 二叉树的层序遍历 II
public class lc107 {
    public static void main(String[] args) {
        class Solution {
    /*BFS:
        通过深度优先搜索进行处理，首先进入的是上层，其次才是下层，并构造当前层存储容器。
        为了满足自底向上的层序遍历，在每进入新一层构建当前层存储容器时，需要将存储容器插入到结果集的头部
    */

            List<List<Integer>> res = new ArrayList<>();
            public List<List<Integer>> levelOrderBottom(TreeNode root) {
                levelOrderBottom(root, 0);  //起始结点和层数
                return res;
            }

            public void levelOrderBottom(TreeNode root, int level) {
                if (root == null)
                    return;
                if (res.size() <= level) //如果集合res的大小比层数小的话
                    res.add(0, new ArrayList<>());  //创建一个空的链表放在第一个位置

                res.get(res.size() - level - 1).add(root.val);  //向倒数第几个位置插入当前结点
                levelOrderBottom(root.left, level + 1);     //向左边结点递归，层数+1
                levelOrderBottom(root.right, level + 1);    //同上
            }
        }
    }
}

package com.csu.yilingyiToyibaiwu;


//力扣109 有序链表转换二叉搜索树
public class lc109 {
    public static void main(String[] args) {
        class Solution {
            public TreeNode sortedListToBST(ListNode head) {
                return buildTree(head, null);
            }

            public TreeNode buildTree(ListNode left, ListNode right) {
                if (left == right) {
                    return null;
                }
                ListNode mid = getMedian(left, right);
                TreeNode root = new TreeNode(mid.val);
                root.left = buildTree(left, mid);
                root.right = buildTree(mid.next, right);
                return root;
            }

            //获取链表中位数的方法
            public ListNode getMedian(ListNode left, ListNode right) {
                ListNode fast = left;
                ListNode slow = left;
                while (fast != right && fast.next != right) {
                    fast = fast.next;
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
    }
}

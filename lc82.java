package com.csu.wuyitoyibai;

//力扣82 删除排序链表中的重复元素 II
public class lc82 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //使用快慢针解决
            ListNode ret = new ListNode(0);
            ret.next = head;
            ListNode slow = ret, fast = head;

            while (fast != null && fast.next != null) {
                if (slow.next.val == fast.next.val) {
                    fast = fast.next.next;
                    while (fast != null && fast.val == slow.next.val)
                        fast = fast.next;
                    slow.next = fast;
                } else {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            return ret.next;
        }
    }
}

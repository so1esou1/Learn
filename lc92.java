package com.csu.wuyitoyibai;

//力扣92  反转链表 II
public class lc92 {
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //以为可以使用归并排序、希尔排序，细想发现其实并不可以
            //可以使用双指针,并创建哨兵节点:
            if (left == right) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for(int i = 1; i < left; i++){
                pre = pre.next;
            }
            head = pre.next;
            for(int i = left; i < right; i++){
                ListNode nex = head.next;
                head.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
            }
            return dummy.next;
        }
    }
}

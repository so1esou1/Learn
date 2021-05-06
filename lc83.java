package com.csu.wuyitoyibai;

//力扣83 删除排序链表中的重复元素
public class lc83 {
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
            //逐个遍历链表中的元素，遇到重复元素直接跳过
            if(head == null)
                return null;
            ListNode remenberTop = head;
            ListNode next = head.next;
            while(head != null && next != null)
            {
                if(next.val == head.val)
                {
                    next = next.next;
                    head.next = next;
                }
                else
                {
                    head = head.next;
                    next = head.next;
                }
            }
            return remenberTop;
        }
    }
}

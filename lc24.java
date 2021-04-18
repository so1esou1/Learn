package com.csu.yitosanshi;

//力扣24 两两交换链表中的节点
public class lc24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode temp = head.next;
            head.next = swapPairs(head.next.next);
            temp.next = head;
            return temp;
        }
    }
}

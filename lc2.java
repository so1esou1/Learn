package com.csu.yitosanshi;

//力扣第二题，两数相加
public class lc2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode temp1 = l1;
            ListNode temp2 = l2;
            ListNode point = head;
            int a = 0;
            while(temp1 != null || temp2 != null){
                int num1 = (temp1 == null) ? 0 : temp1.val;
                int num2 = (temp2 == null) ? 0 : temp2.val;
                int sum = a + num1 + num2;
                point.next = new ListNode(sum % 10);
                point = point.next;
                a = sum / 10;
                if(temp1 != null){
                    temp1 = temp1.next;
                }
                if(temp2 != null){
                    temp2 = temp2.next;
                }
            }
            if(a == 1){
                point.next = new ListNode(a);
            }
            return head.next;
        }
    }
}

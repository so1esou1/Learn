package com.csu.wuyitoyibai;

//力扣61 旋转链表
public class lc61 {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            //链表长度是 len， n = k % len，我们只需要将末尾 n 个链表节点整体移动到最前边就可以了
            if (head == null || k == 0) {
                return head;
            }
            int len = 0;
            ListNode h = head;
            ListNode tail = null;
            //求出链表长度，保存尾指针
            while (h != null) {
                h = h.next;
                len++;
                if (h != null) {
                    tail = h;
                }
            }
            //求出需要整体移动多少个节点
            int n = k % len;
            if (n == 0) {
                return head;
            }

            //利用快慢指针找出倒数 n + 1 个节点的指针，用 slow 保存
            ListNode fast = head;
            while (n >= 0) {
                fast = fast.next;
                n--;
            }
            ListNode slow = head;
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //尾指针指向头结点
            tail.next = head;
            //头指针更新为倒数第 n 个节点
            head = slow.next;
            //尾指针置为 null
            slow.next = null;
            return head;
        }
    }
}

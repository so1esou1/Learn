package com.csu.wuyitoyibai;

//力扣86 分隔链表
public class lc86 {
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
        public ListNode partition(ListNode head, int x) {
            //使用快排的思想:
            //将链表分成了两部分，一部分的数字全部小于分区点 x，另一部分全部大于等于分区点 x。
            //换成了链表，要求不能改变数字的相对位置。所以不能用交换的策略了，直接用插入就可以了。

            ListNode dummy = new ListNode(0);   //dummy是哨兵节点
            dummy.next = head;
            ListNode tail = null;
            head = dummy;
            //找到第一个大于等于分区点的节点，tail 指向它的前边
            while (head.next != null) {
                if (head.next.val >= x) {
                    tail = head;
                    head = head.next;
                    break;
                }else {
                    head = head.next;
                }
            }
            while (head.next != null) {
                //如果当前节点小于分区点，就把它插入到 tail 的后边
                if (head.next.val < x) {
                    //拿出要插入的节点
                    ListNode move = head.next;
                    //将要插入的结点移除
                    head.next = move.next;
                    //将 move 插入到 tail 后边
                    move.next = tail.next;
                    tail.next = move;
                    //更新 tail
                    tail = move;
                }else{
                    head = head.next;
                }

            }
            return dummy.next;
        }
    }
}

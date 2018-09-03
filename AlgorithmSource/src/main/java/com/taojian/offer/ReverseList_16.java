package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 16:22
 *
 * 反转链表
 **/
public class ReverseList_16 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.nextNode == null)
            return head;
        ListNode next = head.nextNode;
        head.nextNode = null;
        ListNode newHead = ReverseList(next);
        next.nextNode = head;
        return newHead;
    }

    public ListNode ReverseList1(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.nextNode;
            head.nextNode = newList.nextNode;
            newList.nextNode = head;
            head = next;
        }
        return newList.nextNode;
    }
}

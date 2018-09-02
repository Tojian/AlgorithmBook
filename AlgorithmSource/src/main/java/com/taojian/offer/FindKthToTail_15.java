package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 16:18
 * <p>
 * 链表倒数第k个节点
 * <p>
 * 方法1 ：递归
 * 方法2 ；两个指针，一个指针先走k，后面两个指针同时移动
 **/
public class FindKthToTail_15 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode P1 = head;
        while (P1 != null && k-- > 0) {
            P1 = P1.nextNode;
        }
        if (k > 0) {
            return null;
        }
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.nextNode;
            P2 = P2.nextNode;
        }
        return P2;
    }
}

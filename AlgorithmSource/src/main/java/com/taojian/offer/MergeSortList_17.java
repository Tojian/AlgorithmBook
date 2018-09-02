package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 16:27
 **/
public class MergeSortList_17 {

    public ListNode Merge(ListNode list1, ListNode list2)
    {
        ListNode head = new ListNode(-1);

        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                cur.nextNode = list1;
                list1 = list1.nextNode;
            } else {
                cur.nextNode = list2;
                list2 = list2.nextNode;
            }
            cur = cur.nextNode;
        }
        if (list1 != null)
            cur.nextNode = list1;
        if (list2 != null)
            cur.nextNode = list2;
        return head.nextNode;
    }
}

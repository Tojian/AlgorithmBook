package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 15:52
 * <p>
 * 在O(1)的时间复杂度删除一个节点
 **/
public class DeleteNode_13 {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || head.nextNode == null || tobeDelete == null) {
            return null;
        }
        if (tobeDelete.nextNode != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.nextNode;
            tobeDelete.data = next.data;
            tobeDelete.nextNode = next.nextNode;
        } else {
            ListNode cur = head;
            while (cur.nextNode != tobeDelete) {
                cur = cur.nextNode;
            }
            cur.nextNode = null;
        }
        return head;
    }
}

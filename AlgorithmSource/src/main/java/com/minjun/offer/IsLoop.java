package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/15.
 *
 * 判断一个链表是否是一个环
 *
 * 定义两个指针，一个快指针(fast)，假如每次移动两步；一个慢指针(slow)，假如每次移动一步。
 * 判断两个指针能否相遇，如果能，则是一个环。如果不能，快指针一定先指向NULL，则不成环
 */
public class IsLoop {
    static class Node{
        int value;
        Node next;
    }
    public static boolean isLoop(Node node){
        if(node == null || node.next == null){
            return false;
        }
        Node fast = node;
        Node slow = node;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null)
            return false;
        else
            return true;
    }
}

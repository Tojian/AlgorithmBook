package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 删除链表中重复的结点
 *
 * 难点在于 如果头节点是重复节点的话，怎么处理
 */
public class DeleteDuplication {

    public static IsLoop.Node deleteDuplication(IsLoop.Node node){
        if(node == null || node.next == null)
            return node;
        IsLoop.Node next = node.next;

        if(node.value == next.value){
            while(next != null && node.value == next.value){
                next = next.next;
            }
            return deleteDuplication(next);
        }else {
            node.next = deleteDuplication(node.next);
            return node;
        }
    }

    public static void main(String args[]){
        IsLoop.Node head = new IsLoop.Node(1);
        IsLoop.Node p1 = new IsLoop.Node(2);
        IsLoop.Node p2 = new IsLoop.Node(2);
        IsLoop.Node p3 = new IsLoop.Node(3);
        IsLoop.Node p4 = new IsLoop.Node(3);
        IsLoop.Node p5 = new IsLoop.Node(4);

        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        IsLoop.Node re = deleteDuplication(head);
        System.out.println(re);
    }

}

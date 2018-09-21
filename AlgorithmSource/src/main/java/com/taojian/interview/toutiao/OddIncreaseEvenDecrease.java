package com.taojian.interview.toutiao;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-10 09:00
 **/
public class OddIncreaseEvenDecrease {

    static class Node{
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
    }
    /**
     * 按照奇偶位拆分成两个链表
     * @param head
     * @return
     */
    public static Node[] getLists(Node head){
        Node head1 = null;
        Node head2 = null;

        Node cur1 = null;
        Node cur2 = null;
        int count = 1;//用来计数
        while(head != null){
            if(count % 2 == 1){
                if(cur1 != null){
                    cur1.next = head;
                    cur1 = cur1.next;
                }else{
                    cur1 = head;
                    head1 = cur1;
                }
            }else{
                if(cur2 != null){
                    cur2.next = head;
                    cur2 = cur2.next;
                }else{
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count++;
        }
        //跳出循环，要让最后两个末尾元素的下一个都指向null
        cur1.next = null;
        cur2.next = null;

        Node[] nodes = new Node[]{head1, head2};
        return nodes;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public static Node CombineList(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while(cur1 != null && cur2 != null){
            if(cur1.value <= cur2.value){//这里一定要有=，否则一旦cur1的value和cur2的value相等的话，下面的pre.next会出现空指针异常
                pre = cur1;
                cur1 = cur1.next;
            }else{
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }

    public static void main(String[] args) {
        Node head = init();
        Node[] lists = getLists(head);

        Node head1 = lists[0];
        Node head2 = lists[1];
        head2 = reverseList(head2);

        head = CombineList(head1, head2);
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static Node init(){
        Node node1 = new Node(1);
        Node node2 = new Node(8);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(5);
        Node node6 = new Node(4);
        Node node7 = new Node(7);
        Node node8 = new Node(2);
        Node node9 = new Node(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }

}

package com.offer.demo;

/**
 * 反转链表
 */
public class PrintListRevertsingly {

    public static void main(String[] args) {

    }


    public void printListRevertsingly_Recursively(ListNode listNode){

      if (listNode != null){
          if (listNode.nextNode != null){
              printListRevertsingly_Recursively(listNode.nextNode);
          }
          System.out.println(listNode.data + " ");
      }


    }
}

class  ListNode{

    int data;

    public ListNode nextNode;

}
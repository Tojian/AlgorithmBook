package com.taojian.demo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 从头到尾打印链表
 * @author: taojian
 * @create: 2018-07-14 17:29
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值
 **/
public class printListFromTailToHead {

    public static void main(String[] args) {


    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.add(listNode.data);
            listNode = listNode.nextNode;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

   public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (listNode.nextNode!=null)
            arrayList.addAll(printListFromTailToHead(listNode.nextNode));
        arrayList.add(listNode.data);
        return arrayList;
   }

}

package com.taojian.offer;

import java.util.Stack;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-05 18:42
 **/
public class CQueue_7 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size() > 0)
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue_7 cQueue_7 = new CQueue_7();
        cQueue_7.push(1);
        cQueue_7.push(2);
        cQueue_7.push(3);
        System.out.println(cQueue_7.pop());
        System.out.println(cQueue_7.pop());
        System.out.println(cQueue_7.pop());

    }
}

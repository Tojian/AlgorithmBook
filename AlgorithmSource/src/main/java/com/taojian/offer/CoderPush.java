package com.taojian.offer;

import java.util.Stack;

/**
 * @description: 用两个栈实现队列
 * @author: taojian
 * @create: 2018-07-14 19:09
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。队列中的元素为 int 类型。
 *
 * 解题思路
 * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
 * 一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out
 * 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，
 * 先进入的元素先退出，这就是队列的顺序。
 **/
public class CoderPush {

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node){
        in.push(node);
    }

    public int pop(){
        while(!in.empty()){
            out.push(in.pop());
        }
        return  out.pop();
    }
    public static void main(String[] args) {

    }
}

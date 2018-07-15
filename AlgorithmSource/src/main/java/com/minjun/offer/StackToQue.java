package com.minjun.offer;

import java.util.Stack;

/**
 * Created by zmjkey on 2018/7/14.
 *
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。队列中的元素为 int 类型。
 *
 */
public class StackToQue {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static void push(int value){
        s1.push(value);
    }

    public static int pop() throws Exception{
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(s2.empty()){
            throw new Exception("queue is empty");
        }
        return s2.pop();
    }

    public static void main(String args[]) throws Exception{
        push(1); push(2); push(3); push(4);
        System.out.println(pop());
        System.out.println(pop());
        push(5); push(6); push(7);
        for(int i = 0; i < 5 ;i++){
            System.out.println(pop());
        }
    }

}

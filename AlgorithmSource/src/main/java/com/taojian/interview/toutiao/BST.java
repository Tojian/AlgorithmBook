package com.taojian.interview.toutiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 */
public class BST {
    public static void main(String[] args) {
        int[][] A = new int[][] {{0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 0, 1}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}};

        int n = A.length;                                                         //元素个数
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> thequeue = new LinkedList<Integer>();                    //LinkedLis实现queue接口
        boolean[] marked = new boolean[n];                                        //marked[i]标记是否被遍历过,遍历过为true
        for (int i = 0; i < n; i++) {
            marked[i] = false;                                                      //初始化标记数组
        }
        int startNode = 3;                                                        //搜索起始结点
        thequeue.offer(startNode);                                              //起始结点装入队列
        result.add(startNode);                                                  //起始结点装入遍历数组
        marked[startNode] = true;                                                 //更新起始结点的访问标志
        while (!thequeue.isEmpty()) {                                             //队列非空
            int v1 = (int) thequeue.poll();
            for (int k = 0; k < n; k++) {

                if (A[v1][k] > 0 && marked[k] == false && v1 != k) {
                    thequeue.offer(k);                                                     //压入队列
                    marked[k] = true;                                                      //更新访问标志位
                    result.add(k);                                                         //更新遍历数组
                }
            }
        }
        System.out.println(result);
    }
}
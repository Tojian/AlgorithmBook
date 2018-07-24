package com.minjun.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindTreePath {
    static List<GetLastNode.TreeNode> list = new ArrayList<GetLastNode.TreeNode>();
    static int sum = 0;

    public static void findTreePath(GetLastNode.TreeNode root, int k){
        if(root == null)
            return ;
        list.add(root);
        sum += root.value;
        //k -= root.value;
        if(root.rightChild == null && root.leftChild == null){
            if(sum == k){
                for(GetLastNode.TreeNode n : list)
                    System.out.print(n.value + " ");
                System.out.println();
            }
        }else {
            findTreePath(root.leftChild, k);
            findTreePath(root.rightChild, k);
        }
        GetLastNode.TreeNode p = list.remove(list.size() - 1);
        sum -= p.value;
    }

    public static void main(String args[]){
        GetLastNode.TreeNode root = new GetLastNode.TreeNode(1);
        GetLastNode.TreeNode p2 = new GetLastNode.TreeNode(2);
        GetLastNode.TreeNode p3 = new GetLastNode.TreeNode(1);
        GetLastNode.TreeNode p4 = new GetLastNode.TreeNode(4);
        GetLastNode.TreeNode p5 = new GetLastNode.TreeNode(5);

        root.leftChild = p2;
        root.rightChild = p3;
        p2.leftChild = p4;
        p3.rightChild = p5;

        findTreePath(root, 7);
    }
}

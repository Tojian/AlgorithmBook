package com.minjun.offer;

import com.minjun.util.TreeNode;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路：如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
 * 否则，向上找第一个左链接指向的树包含该节点的祖先节点
 */
public class FindNextTreeNode {
    public static TreeNode findNextTreeNode(TreeNode root, TreeNode node){
        if(root == null || node == null){
            return root;
        }

        TreeNode p = node;

        if((p = p.right) != null){
            while(p.left != null){
                p = p.left;
            }
            return p;
        }

        p = node;
        while(p.parent != null && p.parent.left != p){
            p = p.parent;
        }

        if(p.parent != null){
            return p.parent;
        }
        return null;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(4);
        TreeNode p4 = new TreeNode(5);
        TreeNode p5 = new TreeNode(6);

        root.left = p1;
        root.right = p4;

        p1.left = p2;
        p1.right = p3;
        p1.parent = root;

        p2.parent = p1;
        p3.parent = p1;

        p3.right = p5;
        p5.parent = p3;

        p4.parent = root;


        TreeNode p = findNextTreeNode(root, p1);

        System.out.println(p.value);

    }

}

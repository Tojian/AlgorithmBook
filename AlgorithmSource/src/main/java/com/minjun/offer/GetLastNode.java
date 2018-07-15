package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/14.
 * 输出完全二叉树最后一层的最右边那个节点
 *
 * 根节点一直递归找左节点，能求出来最大深度，而不是用递归求左右子树深度最大值+1的方法。
 * 求得最大深度之后，从根节点出发，首先从根节点找到左子节点（假设这个点为A），然后从这个子节点一直找右子结点找下去，
 * 找到最底层的孩子，这就是第一次二分；同理，第二次二分，比如你现在应该在第一次分好的左半区查找，找到A的左孩子B，
 * 然后找右孩子找到底层；依次类推。这个二分查找的思路时间复杂度为O(logn)。
 */
public class GetLastNode {
    static class TreeNode{
        int value;
        TreeNode rightChild;
        TreeNode leftChild;

        public TreeNode(int value){
            this.value = value;
        }
    }

    public static TreeNode getLastNode(TreeNode root){
        if(root == null)
            return root;
        TreeNode p = root;
        while(p.leftChild != null || p.rightChild != null){
            p = getMaxLength(p.leftChild) > getMaxLength(p.rightChild) ? p.leftChild : p.rightChild;
        }
        return p;
    }

    public static int getMaxLength(TreeNode root){
        if(root == null)
            return 0;
        int length = 0;
        TreeNode p = root;
        while(p != null){
            length ++;
            p = p.leftChild;
        }
        return length;
    }

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);

        root.leftChild = p2;
        root.rightChild = p3;
        p2.leftChild = p4;
        p2.rightChild = p5;

        TreeNode p = getLastNode(root);
        System.out.println(p.value);
    }
}


package com.taojian.interview.toutiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-10 08:46
 **/
public class PreOrderBinaryTree {


    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     *  根据前序遍历访问的顺序，优先访问根结点，然后再分别访问左孩子和右孩子。即对于任一结点，其可看做是根结点，因此可以直接访问，访问完之后，若其左孩子不为空，按相同规则访问它的左子树；当访问其左子树时，再访问它的右子树。因此其处理过程如下：
     *
     * 对于任一结点P：
     *
     * 1)访问结点P，并将结点P入栈;
     *
     * 2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;
     *
     * 3)直到P为NULL并且栈为空，则遍历结束。
     *
     */

    public static ArrayList preOrder1(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList alist = new ArrayList();
        TreeNode p = root;
        while(p != null || !stack.empty()){
            while(p != null){
                alist.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                TreeNode temp = stack.pop();
                p = temp.right;
            }
        }
        return alist;
    }

    public static void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    /**
     *   根据中序遍历的顺序，对于任一结点，优先访问其左孩子，而左孩子结点又可以看做一根结点，
     *   然后继续访问其左孩子结点，直到遇到左孩子结点为空的结点才进行访问，然后按相同的规则访问其右子树。因此其处理过程如下：
     *
     * 对于任一结点P，
     *
     * 1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
     *
     * 2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；
     *
     * 3)直到P为NULL并且栈为空则遍历结束
     *
     *
     * @param root
     * @return
     */
    public static ArrayList inOrder1(TreeNode root){
        ArrayList alist = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.empty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                TreeNode temp = stack.pop();
                alist.add(temp.val);
                p = temp.right;
            }
        }
        return alist;
    }

    /**
     * 树的层次遍历，故名思议，在一棵树中，把节点从左往右，一层一层的，从上往下，遍历输出，
     * 这里要用到一种很重要的数据结构，队列，一提到队列，我们就要想到先进先进先，即为先进入队列元素，先接受处理，我们在日常生活中排队时，就是先到的人，先接受服务。
     *
     * 理解好队列，可以很容易的解决树的层此遍历，步骤如下：
     *
     *  1.首先将根节点放入队列中。
     *  2.当队列为非空时，循环执行步骤3到步骤5，否则执行6；
     *  3.出队列取得一个结点，访问该结点；
     *  4.若该结点的左子树为非空，则将该结点的左子树入队列；
     *  5.若该结点的右子树为非空，则将该结点的右子树入队列；
     *  6.结束。
     * @param root
     */
    private static void levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp  = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
    }

    class TreeNode{
        TreeNode val;
        TreeNode left;
        TreeNode right;
    }

    }

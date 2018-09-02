package com.taojian.offer;

/**
 * @description: 重建二叉树
 * @author: taojian
 * @create: 2018-07-14 17:46
 **/
public class CreateTreeBinary {

    public static void main(String[] args) {

    }

    public TreeLinkNode createBinayTree(int front[], int frontLeft, int frontRight, int midst[], int midstLeft, int
            midstRight) {
        TreeLinkNode linkNode = null;
        for (int i = 0; i < frontRight; i++) {

            int mid = findindex(midst, front[i]);
            linkNode = new TreeLinkNode(front[i]);
            linkNode.left = createBinayTree(front, 0, frontRight, midst, 0, mid - 1);
            linkNode.right = createBinayTree(front, 0, frontRight, midst, mid + 1, midstRight);
        }
        return linkNode;
    }

    public int findindex(int[] array, int target) {

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
            }
        }
        return index;
    }
}

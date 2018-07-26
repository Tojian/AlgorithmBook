package com.taojian.sort;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-26 11:04
 **/
public class QuickSort {

    //任取一个元素 (如第一个) 为中心
    //所有比它小的元素一律前放，比它大的元素一律后放，形成左右两个子表；
    //对各子表重新选择中心元素并依此规则调整，直到每个子表的元素只剩一个
    //一趟排序过程后我们返回枢纽的位置
    int partition(int A[], int left, int right) {
        //选择枢纽元素
        int p = A[left];
        while (left < right) {
            //如果尾指针位置的数比枢纽数要大，移动尾指针的位置，否则就把所指示的值给首指针的位置
            while (left < right && A[right] >= p) {
                --right;
            }
            A[left] = A[right];
            //如果首指针位置的数比枢纽数要小，移动首指针的位置，否则就把所指示的值给尾指针的位置
            while (left < right && A[left] <= p) {
                ++left;
            }
            A[right] = A[left];
        }
        //此时的首尾指针已经相等，把枢纽的值赋给首尾指针相等的位置即可
        A[left] = p;
        return left;
    }

    //快速排序的递归
    void Quick(int A[], int left, int right) {
        //定义一个枢纽的位置
        int pnode;
        if (left < right) {
            pnode = partition(A, left, right);
            Quick(A, left, pnode - 1);
            Quick(A, pnode + 1, right);
        }
    }

    public static void main(String[] args) {

    }


}

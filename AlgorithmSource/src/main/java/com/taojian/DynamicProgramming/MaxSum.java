package com.taojian.DynamicProgramming;

import static java.lang.Math.max;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-22 13:45
 * 在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。 三角形的行数大于1小于等于100，数字为 0 - 99
 *
 *     输入格式：
 *
 *     5      //表示三角形的行数    接下来输入三角形
 *
 *           7
 *
 *         3   8
 *
 *       8   1   0
 *
 *     2   7   4   4
 *
 *   4   5   2   6   5
 *
 *     要求输出最大和
 *
 *     接下来，我们来分析一下解题思路：
 *
 *     首先，肯定得用二维数组来存放数字三角形
 *
 *     然后我们用D( r, j) 来表示第r行第 j 个数字(r,j从1开始算)
 *
 *     我们用MaxSum(r, j)表示从D(r,j)到底边的各条路径中，最佳路径的数字之和。
 *
 *     因此，此题的最终问题就变成了求 MaxSum(1,1)
 *
 *     当我们看到这个题目的时候，首先想到的就是可以用简单的递归来解题：
 *
 *     D(r, j)出发，下一步只能走D(r+1,j)或者D(r+1, j+1)。故对于N行的三角形，我们可以写出如下的递归式：
 **/
public class MaxSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] maxSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                maxSum[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSum(maxSum,0,0,n));

    }

    /**
     * 递归的方式
     * @param maxsum
     * @param i
     * @param j
     * @return
     */
    public static int maxSum(int [][] maxsum , int i , int j ,int n ){

        if (i == n)
            return maxsum[i][j];
        int x = maxSum(maxsum,i+1,j,n);
        int y = maxSum(maxsum,i+1,j+1,n);
        return max(x,y)+maxsum[i][j];

    }
}

package com.taojian.DynamicProgramming;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-31 16:49
 * <p>
 * N * M 的棋盘，士兵从左上走到右上，只能向上，或者向右，共多少解法
 * <p>
 * 两种走法 ：反过来思考
 * 2 * 3 的棋盘的走法 是通过 2 * 2 的棋盘的状态和 1 * 3 的棋盘共同推出的
 * 向右走 f（n）
 **/
public class SmallSoldierRun {

    // 士兵一次性走一步
    public int f(int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }
        // 条状的棋盘
        if (n == 1 || m == 1) {
            return 1;
        }
        return f(n - 1, m) + f(n, m - 1);
    }

    // 小兵在一个方向走一步或者两步， 走k 步呢？ ==》下楼梯问题
    public int f1(int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }
        // 条状的棋盘
        if (n == 1 || m == 1) {
            return 1;
        }
        return f1(n - 1, m) + f(n, m - 1) + f1(n - 2, m) + f(n, m - 2);
    }

    // 某些格子小兵是禁止走，不需要改变代码，加0 就够了
    public int f2(int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }
        // 条状的棋盘
        if (n == 1 || m == 1) {
            return 1;
        }
        return f2(n - 1, m) + f(n, m - 1);
    }

    /**
     * 组合
     * 若表示在 n 个物品中选取 m 个物品，则如存在下述公式：C(n,m)=C(n,n-m)=C(n-1,m-1)+C(n-1,m)。
     * 从n个不同元素中，任取m(m≤n)个元素并成一组，叫做从n个不同元素中取出m个元素的一个组合；从n个不同元素中取出m(m≤n)个元素的所有组合的个数，叫做从n个不同元素中取出m个元素的组合数。
     *
     * @param n
     * @param r
     */
    int nCr(int n, int r) {
        if (n < r) {
            return 0;
        }
        if (r == 0) {
            System.out.println("==");
            return 0;
        }

        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}

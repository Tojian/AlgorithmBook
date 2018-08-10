package com.taojian.DynamicProgramming;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-08 19:15
 **/
class Knapsack {
    public static void main(String[] args) throws Exception {
        int val[] = {6, 3, 5, 4, 6};
        int wt[] = {2, 2, 6, 5, 4};
        int W = 10;

        System.out.println(knapsack(val, wt, W));
    }

    public static int knapsack(int val[], int wt[], int W) {

        int N = wt.length;

        int[][] V = new int[N + 1][W + 1];

        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }

        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }

        for (int item = 1; item <= N; item++) {

            for (int weight = 1; weight <= W; weight++) {

                if (wt[item - 1] <= weight) {

                    V[item][weight] = Math.max(val[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                } else {
                    V[item][weight] = V[item - 1][weight];
                }
            }

        }

        return V[N][W];
    }

}

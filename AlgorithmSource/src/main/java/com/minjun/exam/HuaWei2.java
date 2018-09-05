package com.minjun.exam;

import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/8.
 *
 * 小偷来到了一个神秘的王宫，突然眼前一亮，发现5个宝贝，每个宝贝的价值都不一样，且重量也不一样，但是小偷的背包携带重量
 * 有限，所以他不得不在宝贝中做出选择，才能使偷到的财富最大，请你帮助小偷计算一下。
 */
public class HuaWei2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String value = in.nextLine();
        String weight = in.nextLine();

        int[] values = conserver(value);
        int[] weights = conserver(weight);

        int num = in.nextInt();

        System.out.println(getMax(values, weights, num));
    }

    private static int getMax(int[] values, int[] weights, int num) {
        int n = weights.length;
        int[][] val = new int[n + 1][num + 1];

        for (int col = 0; col <= num; col++){
            val[0][col] = 0;
        }
        for (int row = 0; row <= n; row++){
            val[row][0] = 0;
        }

        for (int item = 1; item <= n; item++){
            for (int wei = 1; wei <= num; wei++){
                if (weights[item - 1] <= wei){
                    val[item][wei] = Math.max(values[item - 1] + val[item - 1][wei - weights[item - 1]],
                            val[item - 1][wei]);
                }else {
                    val[item][wei] = val[item - 1][wei];
                }
            }
        }
        return val[n][num];
    }

    private static int[] conserver(String str) {
        if(str == null || str.length() == 0)
            return new int[0];
        String[] list = str.split(",");
        int[] num = new int[list.length];
        for (int i = 0; i < list.length; i++){
            num[i] = Integer.valueOf(list[i]);
        }
        return num;
    }
}

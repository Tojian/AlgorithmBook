package com.taojian.graph;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-06 21:19
 **/
public class Main {
    public static int n;
    static int[] v;
    static int[][] a;
    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String k = sc.nextLine();
        n = Integer.parseInt(k);
        a = new int[n + 1][n + 1];
        v = new int[n + 1];
        sum = 0;
        for (int i = 0; i < n - 1; i++) {
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            int d = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            a[d][b] = 1;
            a[b][d] = 1;

        }
        dfs(1);
        System.out.println(sum);
    }

    public static void dfs(int i) {
        Stack stack = new Stack();
        v[i] = 1;
        int m = -1;
        for (int j = 1; j <= n; j++) {
            if (a[i][j] == 1 && v[j] == 0) {
                dfs(j);
                sum++;
                m++;
            }
        }
        if (m != -1) {
            sum = sum + m;
        }
    }
}

package com.taojian.interview.wangyi;

import static java.lang.Integer.max;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-11 16:33
 **/
public class Test2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int k = in.nextInt();

        int[] a = new int[n];

        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }
        System.out.println(solve(t, a, n, k));
    }

    public static int solve(int[] t, int[] a, int n, int k) {
        int sum = 0;
        int ans = 0;
        int maxans = 0;

        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                sum += a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            ans = sum;
            if (t[i] == 0) {
                for (int j = 0; j < k && i + j < n; j++) {
                    if (t[i + j] == 0) {
                        ans += a[i + j];
                    }
                }
                maxans = max(maxans, ans);
            }
        }
        return maxans;
    }

}




package com.taojian.demo;

import java.util.Arrays;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-16 20:54
 *
 *  一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 *  解法 和斐波拉切数一样
 *
 **/
public class JumpFloorTest {

    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int jumpFloor(int n) {

        if (n == 1) {
            return n;
        }
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {

            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];

    }

    //一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int jumpFloor1(int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[n - 1];
    }
    }



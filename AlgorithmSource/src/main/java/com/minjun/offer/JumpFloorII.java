package com.minjun.offer;

import java.util.Arrays;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    public static int jump(int n){
        // 可以用一个数组来记录每级台阶有多少种跳法
        int[] num = new int[n];
        num[0] = 1;
        for(int i = 1; i < n; i++){
            num[i] += 2 * num[i-1];
        }
        return num[n-1];
    }

    public static int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public static void main(String args[]){
        System.out.println("my: "+ jump(17));
        System.out.println("ans: "+ jumpFloorII(17));
    }

}

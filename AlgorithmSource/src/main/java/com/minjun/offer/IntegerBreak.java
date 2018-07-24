package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 */
public class IntegerBreak {

    public static int integerBreak(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                //(i - j) * dp[j]需要和比较(i - j) * (j + 1)，是因为当n>1时，
                // 可以选择中间剪的这一段跟前面剪的最大值相乘，但是也可以将前面的不剪，直接相乘 即（j+1）
                dp[i] = Math.max(Math.max((i - j) * dp[j], (i - j) * (j + 1)), dp[i]);
            }
        }
        return dp[n-1];
    }

    public static void main(String args[]){
        System.out.println(integerBreak(10));
    }
}

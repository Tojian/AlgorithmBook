package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/24.
 *
 * 给定一个数字，按照如下规则翻译成字符串：0 翻译成“a”，1 翻译成“b”... 25 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 注意：这里很容易忘记0的处理,两位的时候，若第一个是0，那么没有两种翻译
 */
public class NumDecodings {

    public static int numDecodings(int n){
        int length = 0;
        for(int i = n; i > 0; i = i/10){
            length ++;
        }

        int dp[] = new int[length];
        dp[0] = 1;

        int data[] = new int[length];

        for(int i = length -1; i >= 0; i--) {
            data[i] = n%10;
            n = n/10;
        }


        dp[1] = data[0]*10 + data[1] <= 25 && data[0] != 0 ? 2 : 1;

        for(int i = 2; i < length; i++){
            if(data[i-1]*10 + data[i] <= 25 && data[i-1] != 0){
                dp[i] = dp[i-1] + dp[i-2];
            }else
                dp[i] = dp[i-1];
        }
        return dp[length-1];
    }

    public static void main(String args[]){
        System.out.print(numDecodings(103));
    }
}

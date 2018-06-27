package com.minjun.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s ="leetcode",
 dict =["leet", "code"].

 Return true because"leetcode"can be segmented as"leet code".

 * Created by zmjkey on 2018/6/27.
 */

public class WordBreak {
    // 动态规划
    public static boolean wordBreak(String s, Set<String> dict) {

        int len = s.length();
        //申请一个数组，存放中间结果
        boolean dp[] = new boolean[len+1];
        dp[0] = true;

        // 循环去遍历j开头，i结尾的字符串，是否包含在dict中，如在，dp[i]设为t，dp[j]做判断是为了接上以前已经为t的位置
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[len];
    }


    public static void main(String[] args){
        String s = "dogs";
        Set<String> dict = new HashSet<String>();
        dict.add("dog");
        dict.add("s");
        dict.add("gs");
        wordBreak(s, dict);
    }
}

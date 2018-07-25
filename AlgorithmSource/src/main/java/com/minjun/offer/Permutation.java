package com.minjun.offer;

import java.util.Arrays;

/**
 * Created by zmjkey on 2018/7/24.
 *
 *  字符串的排列
 *  输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的
 *  所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Permutation {

    public static void permutation(String str){
        char[] list = str.toCharArray();
        Arrays.sort(list);
        boolean[] hasUsed = new boolean[list.length];
        StringBuffer sb = new StringBuffer();
        backingTrace(list, hasUsed, sb);

    }

    public static void backingTrace(char[] list, boolean[] hasUsed, StringBuffer sb) {
        if(sb.length() == list.length)
            System.out.println(sb.toString());
        for(int i = 0; i < list.length; i++){
            if(hasUsed[i])
                continue;
            if(i != 0 && list[i] == list[i-1] && !hasUsed[i-1]){
                continue;
            }
            hasUsed[i] = true;
            sb.append(list[i]);
            backingTrace(list, hasUsed, sb);
            hasUsed[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String args[]){
        permutation("abbc");
    }
}

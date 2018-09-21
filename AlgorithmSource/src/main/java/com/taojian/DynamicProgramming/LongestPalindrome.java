package com.taojian.DynamicProgramming;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-09 15:27
 **/
public class LongestPalindrome {

    public static String getLongestString(String str) {
        int n = str.length();
        boolean[][] val = new boolean[n][n];
        int maxLen = 0;
        int left = 0;
        int right = 0;
        if (str.length() == 0)
            return null;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j) && (i - j < 2 || val[j + 1][i - 1] == true)) {
                    val[j][i] = true;
                    if (maxLen < i - j + 1){
                        maxLen = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
        }

        return str.substring(left,right + 1);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(getLongestString(str));
    }
}

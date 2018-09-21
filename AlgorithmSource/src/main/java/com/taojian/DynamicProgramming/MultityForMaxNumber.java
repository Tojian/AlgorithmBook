package com.taojian.DynamicProgramming;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-09 15:52
 **/
public class MultityForMaxNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        System.out.println(multityForMaxTwoNumber(s1, s2));

    }

    public static String multityForMaxTwoNumber(String num1, String num2) {

        if (num1.length() == 0 && num2.length() == 0) {
            return "0";
        }

        int l = num1.length();
        int r = num2.length();

        int[] num = new int[l + r];

        for (int i = 0; i < l; i++) {

            int n1 = num1.charAt(l - 1 - i) - '0';
            int temp = 0;

            for (int j = 0; j < r; j++) {

                int n2 = num2.charAt(r - 1 - j) - '0';
                temp = temp + num[i + j] + n1 * n2;
                num[i + j] = temp % 10;
                temp /= 10;
            }
            num[i + r] = temp;
        }

        int i = l + r - 1;
        while (i > 0 && num[i] == 0) {
            i--;
        }
        StringBuilder result = new StringBuilder();
        while (i >= 0) {
            result.append(num[i--]);
        }
        return result.toString();
    }

}

package com.taojian.interview.huawei;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        System.out.println(getsum(str.trim()));
    }

    private static int getsum(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        int idx = 0;
        int sum = 0;
        int num = 0;
        int negative = 1;
        while (idx < str.length()) {
            if (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
                num = num * 10 + Integer.valueOf(String.valueOf(str.charAt(idx))).intValue();
            } else if (str.charAt(idx) == '-') {
                negative *= -1;
            } else {
                sum = sum + num * negative;
                negative = 1;
                num = 0;
            }
            idx++;
        }
        sum += num * negative;
        return sum;
    }
}
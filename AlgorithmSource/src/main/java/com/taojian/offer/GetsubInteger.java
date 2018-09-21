package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-08 14:33
 **/
public class GetsubInteger {

    public static void getSubInteger(int n) {
        int min = 1;
        int max = 1;
        int sum = 0;
        while (min <= n / 2 + 1) {
            if (sum == n) {
                System.out.print(n + " = ");
                for (int k = min; k <= max - 1; k++) {
                    if (k < max - 1)
                        System.out.print(k + " + ");
                    else
                        System.out.print(k);
                }
                System.out.println();
                min++;
                max = min;
                sum = 0;
            } else if (sum > n) {
                sum = 0;
                min++;
                max = min;
            } else {
                sum = sum + max;
                max++;
            }
        }

    }

    public static void main(String[] args) {

    }
}

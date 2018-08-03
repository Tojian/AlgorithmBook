package com.taojian.array.binarysearch.middle;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-03 10:23
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 **/
public class PowXandN {

    public double myPow(double x, int n) {

        double res = 1;
        for (int i = 1; i < Math.abs(n); i++) {
            res = res * x;
        }
        if (n > 0) {
            return res;
        } else {
            return 1 / res;
        }
    }

    public static double myPow1(double x, int n) {
        if (n==0)
            return 1;
        if (n==1)
            return x;
        double result = 0.0;
        if( Math.abs(n)%2 == 0)
            result = myPow1(x,Math.abs(n/2))*myPow1(x,Math.abs(n/2));
        else  result = myPow1(x,Math.abs(n/2))*myPow1(x,Math.abs(n/2))*x;
        if (n > 0 )
            return result;
        else return 1/result;
    }


    public static void main(String[] args) {
        System.out.println(myPow1(2.0000,-2));
    }
}

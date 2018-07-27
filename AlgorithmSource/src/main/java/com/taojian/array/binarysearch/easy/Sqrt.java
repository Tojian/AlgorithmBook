package com.taojian.array.binarysearch.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-27 15:54
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is
 * returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 **/
public class Sqrt {

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    private boolean guess(int x, int y) {
        return x * x <= y;
    }

    public int mySqrt2(int y) {
        int L = 0;
        int R = y + 1; // 【0，y)

        while (L < y) {
            int mid = (L - R) / 2 + R;
            if (guess(mid, y)) {
                L = mid;
            } else {
                R = mid;
            }
        }
        return L;
    }

    /**
     * 开方的数肯定 小于本身的一半
     *
     * @param x
     *
     * @return
     */
    public int mySqrt3(int x) {
        long high = (x / 2) + 1;
        long low = 0;
        while (high >= low) {
            long mid = (high + low) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;

    }
}

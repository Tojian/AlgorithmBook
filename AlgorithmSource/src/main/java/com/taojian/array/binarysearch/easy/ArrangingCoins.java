package com.taojian.array.binarysearch.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-28 22:09
 * <p>
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k
 * coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 **/
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = (left - right) / 2 + right;
            if ((mid * (mid + 1) / 2) > n && (mid * (mid + 1) / 2) - mid <= n) {
                return (int) (mid - 1);
            } else if ((mid * (mid + 1) / 2) > n && (mid * (mid + 1) / 2) - mid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int arrangeCoins1(int n) {
        if (n < 1) {
            return 0;
        }
        for (int i = 1; ; i++) {
            n -= i;
            if (n < 0) {
                return i - 1;
            }
        }
    }
}

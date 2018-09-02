package com.taojian.array.binarysearch.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-28 21:56
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 **/
public class GuessNumberHigherOrLower {

    private static int guess(int mid) {
        return 0;
    }

    public int guessNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = (left - right) / 2 + right;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            }
        }
        return -1;
    }
}

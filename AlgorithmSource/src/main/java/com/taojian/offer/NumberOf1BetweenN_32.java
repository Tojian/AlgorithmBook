package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 15:01
 * <p>
 * 从1到n整数中1 出现的次数
 **/
public class NumberOf1BetweenN_32 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(11));
    }
    public static int countDigitOne(int n) {

        if (n <= 0) {
            return 0;
        }
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) {
                ans += n % x + 1;
            }
            if (digit > 1) {
                ans += x;
            }
            x *= 10;
        } while (q > 0);
        return ans;
    }
}

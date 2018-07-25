package com.taojian.demo;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-16 20:38
 *
 * n = 0 。
 * n =1    f（n）= 0
 *
 * f(n-1) +f(n-2) f(n)
 **/
public class FibonacciTest {


    /**
     * 动态规划
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int fibonacci1(int n){

        if (n == 0 || n==1)
         return 0;
        return fibonacci1(n-1) +fibonacci1(n-2);
    }

    /**
     * 循环
     */

    public int fibonacci2(int n) {

        int numSum = 0;
        int numFirst = 0;
        int numSecond = 0;

        if (n == 0 || n == 1) {
            return 0;
        }
        while (n > 1) {
            numSum = numFirst + numSecond;
            numSecond = numSum;
            numFirst = numSecond;
            n--;
        }
     return numSum;
    }

}

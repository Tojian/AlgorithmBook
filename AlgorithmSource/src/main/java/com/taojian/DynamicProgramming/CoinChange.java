package com.taojian.DynamicProgramming;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-25 09:16
 *
You are given coins of different denominations
and a total amount of money amount.
Write a function to compute the fewest number of coins
that you need to make up that amount. If that amount of money cannot
be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1

 **/
public class CoinChange {

    public static void main(String[] args) {


    }
        public static int maxValue = 1000000;
        public int search(int idx, int amount, int[] coins){
            if (amount == 0)
                return 0;
            if ( amount < 0)
                return maxValue;
            if (idx >= coins.length)
                return maxValue;

            int a = search(idx ,amount -coins[idx] ,coins);
            int b = search(idx +1 ,amount ,coins);

            return Math.min(a + 1 ,b);

        }
        public int coinChange(int[] coins, int amount) {
            int res =  search(0,amount,coins);
            if (res < maxValue)
                return res;
            else
                return -1;
        }
    }


package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 14:33
 **/
public class NumberOf1_10 {

    public static int numberOfOne(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(2));
    }
}

package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 15:36
 **/
public class PrintToMaxOfNDigits_12 {

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, -1);
    }

    public static  void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit + 1] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }
    // 前面是 0 不会打印出来
    public static void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }
}

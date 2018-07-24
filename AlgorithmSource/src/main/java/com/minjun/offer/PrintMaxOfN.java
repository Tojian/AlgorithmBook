package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class PrintMaxOfN {

    public static void printMaxOfN(int n){
        if(n <= 0)
            return;
        char[] num = new char[n];
        printMaxOfN(num, -1);

    }

    public static void printMaxOfN(char[] num, int n){
        if(num.length - 1 == n){
            printNum(num);
            return;
        }

        for(int i = 0; i < 10; i++){
            num[n + 1] = (char) ('0' + i);
            printMaxOfN(num, n + 1);
        }

    }

    private static void printNum(char[] num) {

        int n = 0;
        while(n < num.length && num[n] == '0'){
            n++;
        }
        while(n < num.length){
            System.out.print(num[n++]);
        }

        System.out.println();
    }

    public static void main(String args[]){
        printMaxOfN(2);
    }

}

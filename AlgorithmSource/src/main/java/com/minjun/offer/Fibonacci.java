package com.minjun.offer;

/**
 * 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * Created by zmjkey on 2018/6/27.
 */
public class Fibonacci {

    public int fibonacci1(int n) {
        //递归
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 1;
        }
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    //循环
    public int fibonacci2(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n ==2){
            return 1;
        }
        int a = 1, b = 1;
        int sum = 0;
        for(int i = 3;i <= n;i++){
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // 数组保存计算结果
    public int fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n ==2){
            return 1;
        }
        int result[] = new int[n];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2;i < n;i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n-1];
    }
}

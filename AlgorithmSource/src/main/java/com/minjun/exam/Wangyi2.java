package com.minjun.exam;

import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/11.
 */
public class Wangyi2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] q = new int[m];

        for(int i = 0; i < m; i++){
            q[i] = in.nextInt();
        }

        getNum(n, a, m, q);
    }

    private static void getNum(int n, int[] a, int m, int[] q) {
        int[] num = new int[n+1];
        num[0] = 0;
        for(int i = 0; i < n; i++){
            num[i+1] = num[i] + a[i];
        }

        for (int i = 0 ; i < m; i++){
            int j = 0;
            int target = q[i];
            if(num[j] > target){
                System.out.println(0);
            }
            while(j < n && num[j] < target){
                j ++;
            }

            System.out.println(j);
        }
    }
}

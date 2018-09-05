package com.minjun.exam;

import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/11.
 */
public class wangyi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] values = new int[n];
        int[] bool = new int[n];

        for(int i = 0; i < n; i++){
            values[i] = in.nextInt();
        }

        for(int i = 0; i < n; i++){
            bool[i] = in.nextInt();
        }

        System.out.println(getMax(n, values, bool, k));
    }

    private static int getMax(int n, int[] values, int[] bool, int k) {
        if(n <= 0 || k < 0){
            return 0;
        }

        int max = 0;

        if(k == 0){
            for(int i = 0; i < n; i++){
                max += bool[i] != 0 ? values[i] : 0;
            }
            return max;
        }

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += (bool[j] != 0 || (j >= i && j - i < k)) ? values[j] : 0;
            }
            max = max < sum ? sum : max;
        }

        return max;
    }

}

package com.minjun.exam;

/**
 * Created by zmjkey on 2018/8/27.
 */

import java.util.HashSet;
import java.util.Scanner;

public class w1{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            int Q = sc.nextInt();
            for(int i=0; i<Q; i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                diffFlowers(a, l-1, r-1);
            }
        }
        sc.close();
    }

    private static void diffFlowers(int [] flowers, int l, int r){
        HashSet<Integer> set = new HashSet<>();
        for(int i=l; i<=r; i++){
            set.add(flowers[i]);
        }
        System.out.println(set.size());
    }
}
package com.minjun.exam;

import java.util.Scanner;

public class T1 {
    static String[] name = {"Alice", "Bob", "Cathy", "Dave"};
    static int cnt = 4;
    public static String getName(int n){
        while(n >= cnt){
            n -= cnt;
            cnt *= 2;
        }
        if(n == 0){
            int k = cnt/4;
            k = n/k;
            return name[k];
        }
        else{
            return name[name.length - 1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = getName(n);
        System.out.println(name);
    }
}
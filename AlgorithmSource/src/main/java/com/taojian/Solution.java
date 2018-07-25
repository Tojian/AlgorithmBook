package com.taojian;

import static java.lang.Math.log;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-22 19:05
 * 有N个货物（0<=N<=1024），每个货物的重量是W（100<=W<=300）。如果每辆车最多的载重为300，请问最少需要多少辆车才能运输所有货物。
 **/
public class Solution {
    public static void main(String[] args) {

        getSolution(9);
    }

/*    *//**
     * N = int(input())
     * name = ["Alice" , "Blob" , "Cathy" , "Dave"]
     *
     * cnt = 4
     *
     * while N >= cnt:
     *     N -= cnt;
     *     cnt *=2
     * if N:
     *     print(name[N//(cnt//4)])
     * else:
     *     print(name[-1])
     */

    public static void getSolution(int n){
       String [] name = {"Alice" , "Bob" , "Cathy" , "Dave"};
       int cnt = 4;
       while (n >= cnt){
           n -= cnt;
           cnt *=2;

       }
       if (n != 0){
           System.out.println(name[(n/(cnt/4))-1]);
       }
        else System.out.println(name[3]);
        }
    /**
     * goods = list(map(int, input().split()))
     * goods.sort()
     *
     * result = 0
     *
     * while len(goods) > 1:
     *     if goods[-1]+goods[0] >300 :
     *         goods.pop()
     *     else :
     *         goods =goods[1:-1]
     *     result +=1
     * print(result + len(goods))
     */

    public void getSolution1(int [] goods){
        Arrays.sort(goods);

        int result = 0;

        while (goods.length > 1){

        }
    }


}

package com.taojian.interview._360;

import java.util.HashMap;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-27 19:11
 * <p>
 * 小红有两个长度为n的排列A和B。每个排列由[1,n]数组成，且里面的数字都是不同的。
 * <p>
 * 现在要找到一个新的序列C，要求这个新序列中任意两个位置(i,j)满足:
 * <p>
 * 如果在A数组中C[i]这个数在C[j]的后面，那么在B数组中需要C[i]这个数在C[j]的前面。
 * <p>
 * 请问C序列的长度最长为多少呢？
 **/
public class Test {
    public static void main(String[] args) {
        byte a = 3;
        byte b = 2;
        a += b;
        System.out.println(b);
    }

    public int compareTwoOfArray(int[] a, int[] b) {

        HashMap<Integer, Integer> aHahMap = new HashMap<>();
        HashMap<Integer, Integer> bHashMap = new HashMap<>();
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < a.length; i--) {
            temp.put(a[i], i);
        }
        //        int[] c = new int[];
        //        for (int i = 0 ; i < a.length ; i --){
        //            if (temp.containsKey(a[i])){
        //                aHahMap.put(a[i],i);
        //              //  c[i] = a[i];
        //            }
        //        }
        //        for (int i = 0 ; i < b.length ; i --){
        //            if (temp.containsKey(b[i]))
        //                bHashMap.put(b[i],i);
        //        }

        return 0;

    }
}

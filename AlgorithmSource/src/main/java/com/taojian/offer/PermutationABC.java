package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-06 20:32
 *
 * 字母全排序
 **/
public class PermutationABC {

    public static void Permutation(char[] s, int from, int to) {
        if(to<=1)
            return;
        if(from == to){
            System.out.println(s);
        }
        else{
            for(int i=from;i<=to;i++){
                swap(s,i,from);
                Permutation(s,from+1,to);
                swap(s,from,i);
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/15.
 *
 * 给定一个数组A（1-100）判断A里面是否有重复元素
 *
 * 定义一个hashmap集合，key存放A中的元素值，value存放该元素值出现的次数，假如用count表示，如果count>=2,说明有重复元素
 *
 * 每次这样的题目，考虑用到数组的下标
 */
public class HasSameNum {
    public static boolean hasSameNum(int data[]){
        for(int i = 0; i < data.length; i++){
            if(data[i] != i){
                while (data[i] != i){
                    if(data[i] == data[data[i]])
                        return true;
                    swap(data, i , data[i]);
                }
            }
        }
        return false;
    }

    public static void swap(int data[], int k1, int k2){
        int temp = data[k1];
        data[k1] = data[k2];
        data[k2] = temp;
    }

    public static void main(String args[]){
        int[] data = {1,2,3,0,5,6,0};
        System.out.println(hasSameNum(data));
    }
}

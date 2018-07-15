package com.minjun.sort;

import java.util.Arrays;

/**
 * 直接选择排序，从头至尾顺序扫描序列，找出最小的一个记录，和第一个记录交换，接着从剩下的记录中继续这种选择和交换，最终使序列有序。
 * Created by zmjkey on 2018/7/9.
 */
public class SelectSort {
    public static void sort(int data[]){

        int temp,k=0;
        for(int i = 0; i< data.length; i++){
            k = i;
            for(int j = i; j < data.length; j++){
                if(data[j] < data[k]){
                    k = j;
                }
            }
            temp = data[k];
            data[k] = data[i];
            data[i] = temp;
        }

    }
    public static void main(String[] args) {

        int [] array = {5,3,0,2,4,1,0,5,2,3,1,4};
        System.out.println("Before: " + Arrays.toString(array));
        sort(array);
        System.out.println("After:  " + Arrays.toString(array));

    }
}

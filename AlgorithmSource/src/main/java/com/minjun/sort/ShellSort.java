package com.minjun.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 *
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
 * 分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * Created by zmjkey on 2018/7/9.
 */
public class ShellSort {
    public static void sort(int data[]){
        int temp, h = 1;
        int j;

        while(h < data.length/3){
            h = h *3 +1;
        }

        while(h > 0){
            for(int i = h; i < data.length; i++){
                temp = data[i];
                j = i - h;
                while(j >= 0 && data[j] > temp){
                    data[j+h] = data[j];
                    j-=h;
                }
                data[j + h] = temp;
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {

        int [] array = {5,3,0,2,4,1,0,5,2,3,1,4};
        System.out.println("Before: " + Arrays.toString(array));
        sort(array);
        System.out.println("After:  " + Arrays.toString(array));

    }
}

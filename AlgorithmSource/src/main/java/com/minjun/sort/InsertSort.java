package com.minjun.sort;

/**
 * 插入类排序
 * 直接插入、折半插入、希尔排序
 * Created by zmjkey on 2018/7/9.
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 1 算法描述
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 *
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */
public class InsertSort {
    public void sort(int data[]){
        if(data.length <= 0)
            return ;

        int temp;
        int i,j;

        // 从待排元素之前的元素开始扫描，如果大于待排元素，则后移一位
        for(i = 1; i < data.length; i++){
            temp = data[i];
            j =  i - 1;
            while(j >= 0 && data[j] > temp){
                data[j+1] =  data[j];
                j--;
            }
            if(j >= 0){
                data[j+1] = temp; //找到插入位置
            }
        }
    }

}

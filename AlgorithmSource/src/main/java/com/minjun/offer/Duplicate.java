package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/14.
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5}，那么对应的输出是第一个重复的数字 2。
 * 要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *
 * 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上。
 */
public class Duplicate {
    public static int duplicate(int[] data){
        if(data.length <= 0){
            return -1;
        }
        for(int i = 0; i < data.length; i++){
                while(data[i] != i){
                    if (data[i] == data[data[i]])
                        return data[i];
                    swap(data, i, data[i]);
                }
            }

        return -1;
    }

    public static void swap(int data[], int v1, int v2){
        int temp;
        temp = data[v1];
        data[v1] = data[v2];
        data[v2] = temp;
    }

    public static void main(String args[]){
        int[] data = {2, 3, 0, 1, 2, 5};
        int result = duplicate(data);
        System.out.println("After:  " + result);

    }
}

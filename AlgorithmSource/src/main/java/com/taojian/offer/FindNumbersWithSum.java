package com.taojian.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-08 19:21
 **/
public class FindNumbersWithSum {

    public static void main(String[] args) {

        int [] array = {1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(array,15));
    }
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], i);
        }
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {

            if (hashMap.containsKey(sum - array[i])) {
                if (min > array[i] * (sum - array[i])) {
                    min = array[i] * (sum - array[i]);
                    while(arrayList.size() > 0){
                        arrayList.remove(arrayList.size() - 1);
                    }
                    arrayList.add(array[i]);
                    arrayList.add(sum - array[i]);
                }
            }
        }
        return arrayList;
    }
}

package com.taojian.array.binarysearch.middle;

import java.util.ArrayList;

import java.util.List;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 15:18
 * <p>
 * <p>
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also
 * be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 * UPDATE (2017/9/19):
 * The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code
 * definition to get the latest changes.
 **/
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        if (arr == null || arr.length == 0 || k == 0) {
            return res;
        }

        int l = 0;
        int r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

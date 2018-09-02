package com.taojian.array.binarysearch.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-28 21:31
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
 * into the memory at once?
 **/
public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; ++i) {
            int a = map.getOrDefault(nums2[i], 0);
            if (a != 0) {
                resList.add(nums2[i]);
                map.put(nums2[i], a - 1);
            }
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); ++i) {
            res[i] = resList.get(i);
        }
        return res;
    }
}

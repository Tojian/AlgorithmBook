package com.taojian.array.binarysearch.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-28 20:42
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 **/
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int [] nums1 = {4,7,9,7,6,7};
        int [] nums2 ={5,0,0,6,1,6,2,2,4};
        int [] result = intersection(nums1,nums2);
        for(int i = 0 ; i < result.length ;i++){
            System.out.println(result[i] + " ");
        }
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < 0 || nums2.length < 0)
            return null;
        Set<Integer> hashset = new HashSet<Integer>();
        int tempLength = Math.min(nums1.length,nums2.length);
        int []temp = new int[tempLength];
        int j = 0;
        int resultLength = 0;
        for (int i = 0 ; i < nums2.length ; i++){
            hashset.add(nums2[i]);
        }
        for (int i = 0 ; i < nums1.length ; i++){
            int left = 0;
            int right = nums2.length - 1;
            while (left <= right){
                int mid = (left - right)/2 + right;
                if (nums2[mid] == nums1[i] && hashset.contains(nums2[mid])){
                    temp[j++] = nums2[mid];
                    resultLength ++;
                    hashset.remove(nums2[mid]);
                    break;
                }
                else if(nums2[mid] > nums1[i])
                    right = mid -1;
                else left = mid + 1;
            }
        }
        return Arrays.copyOf(temp,resultLength);
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}

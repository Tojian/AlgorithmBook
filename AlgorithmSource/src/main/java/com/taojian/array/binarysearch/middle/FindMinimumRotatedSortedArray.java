package com.taojian.array.binarysearch.middle;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-31 15:06
 * <p>
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 **/
public class FindMinimumRotatedSortedArray {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {  // while (left < right-1) is a useful technique
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return nums[right];
        }
        return nums[left];
    }

}

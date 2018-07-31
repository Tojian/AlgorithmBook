package com.taojian.array.binarysearch.middle;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-31 11:05
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at
 * least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 **/
public class FindtheDuplicateNumber {
    /**
     * Status: Time Limit Exceeded
     * Submitted: 0 minutes ago
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums.length<=1)
            return 0;

        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int result = 0;
        for(int i = 0 ; i < nums.length ;i++){
            if(hashmap.containsValue(nums[i])){
                result = nums[i];
            }else hashmap.put(i,nums[i]);
        }
         return result;
    }

    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

}

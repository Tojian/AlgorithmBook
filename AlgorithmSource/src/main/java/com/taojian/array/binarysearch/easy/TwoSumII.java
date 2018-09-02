package com.taojian.array.binarysearch.easy;

import java.util.HashMap;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-28 16:31
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
 * must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 **/
public class TwoSumII {

    public static void main(String[] args) {
        int[] nums = {5, 25, 75};
        int[] res = twoSum(nums, 100);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 0) {
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            while (left <= right) {
                int mid = (left - right) / 2 + right;
                if (numbers[mid] == temp) {
                    return new int[] {i + 1, mid + 1};
                } else if (numbers[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        if (numbers.length < 0) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                return new int[] {i + 1, hashMap.get(target - numbers[i]) + 1};
            } else {
                hashMap.put(numbers[i], i);
            }
        }
        return null;
    }

    /**
     * 双指针
     *
     * @param numbers
     * @param target
     *
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int len = numbers.length;
        int sum;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}

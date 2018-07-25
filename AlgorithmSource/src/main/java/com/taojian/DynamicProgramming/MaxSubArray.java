package com.taojian.DynamicProgramming;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-22 15:52
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 **/
public class MaxSubArray {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划
     *
     * @param nums
     *
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int cur = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }

    /**
     * 循环的方式
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {

        int cur = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (cur < 0) {
                cur = nums[i];
            } else {
                cur = cur + nums[i];
            }
            if (res < cur) {

                res = cur;
            }

        }
        return res;
    }
}

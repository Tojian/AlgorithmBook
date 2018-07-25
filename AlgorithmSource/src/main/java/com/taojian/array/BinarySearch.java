package com.taojian.array;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-25 20:48
 * 二分查找
 **/
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 4, 5, 8, 9};
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearchRecursion(nums, 1, 0, nums.length - 1));
    }

    /**
     * 循环
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums.length < 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left - right) / 2 + right;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     *
     * @return
     */
    public static int binarySearchRecursion(int[] nums, int target, int left, int right) {

        if (nums.length < 0 || left < 0 || right > nums.length - 1) {
            return -1;
        }

        int mid = (left - right) / 2 + right;
        if (left <= right) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                return binarySearchRecursion(nums, target, mid + 1, right);
            } else {
                return binarySearchRecursion(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

}

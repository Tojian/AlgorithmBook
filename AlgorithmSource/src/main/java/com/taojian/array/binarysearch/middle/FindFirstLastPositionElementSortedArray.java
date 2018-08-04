package com.taojian.array.binarysearch.middle;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-03 17:13
 **/
public class FindFirstLastPositionElementSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length < 0) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (result >= 0) {
            for (int i = result; i >= 0; i--) {
                if (nums[i] != nums[result]) {
                    res[0] = i + 1;
                    break;
                }
            }
            for (int i = result; i <= nums.length; i++) {
                if (i == nums.length) {
                    res[1] = nums.length - 1;
                }
                if (nums[i] != nums[result]) {
                    res[1] = i - 1;
                    break;
                }
            }
        } else {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(searchRange(nums, 2));
    }
}

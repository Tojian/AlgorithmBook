package com.taojian.offer;

/**
 * @description: 调整数组顺序使奇数位于偶数前面
 * @author: taojian
 * @create: 2018-09-02 16:09
 **/
public class ReorderOddEvent_14 {

    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            } else {
                nums[j++] = num;
            }
        }
    }

    public void reOrderOddEvent(int[] nums, int length) {
        if (nums.length <= 0) {
            return;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {

            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right++;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
}

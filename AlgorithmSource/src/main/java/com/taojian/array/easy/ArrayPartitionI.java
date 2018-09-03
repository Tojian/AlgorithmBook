package com.taojian.array.easy;

import java.util.Arrays;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 16:17
 **/
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum = sum + nums[i];
        }
        return sum;
    }
}

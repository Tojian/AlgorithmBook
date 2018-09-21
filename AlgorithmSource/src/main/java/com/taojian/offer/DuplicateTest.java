package com.taojian.offer;

import java.util.HashMap;

/**
 * @description: 数组中重复的数字
 * @author: taojian
 * @create: 2018-07-14 15:46
 * <p>
 * <p>
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5}，那么对应的输出是第一个重复的数字
 * 2。
 * <p>
 * 要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)。
 * 因此不能使用排序的方法，也不能使用额外的标记数组。牛客网讨论区这一题的首票答案使用 nums[i] + length
 * 来将元素标记，这么做会有加法溢出问题。
 * <p>
 * 解题思路
 * 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上。
 * <p>
 * 以 (2, 3, 1, 0, 2, 5) 为例：
 **/
public class DuplicateTest {

    public static void main(String[] args) {

        int[] nums = {};
        int[] duplication = new int[1];
        if (duplicate(nums, nums.length, duplication)) {
            System.out.println(duplication[0]);
        }

        System.out.println(duplicate1(nums,0,duplication) );
        System.out.println(duplication[0]);
    }

    public static boolean duplicate1(int numbers[],int length,int [] duplication) {

        if (numbers.length == 0 || length == 0 || numbers == null){
            duplication[0] = -1;
            return false;
        }

        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();

        for (int i = 0; i < numbers.length; i ++){
            if (hashmap.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                hashmap.put(numbers[i],i);
            }
        }
        duplication[0] = -1;
        return false;

    }
    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

package com.taojian.interview.wangyi;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-11 15:47
 **/
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int count = in.nextInt();
        int[] target = new int[count];

        for (int i = 0; i < count; i++) {
            target[i] = in.nextInt();
        }
        int[] res = returnNums(nums, count, target);
        for (int h : res) {
            System.out.println(h);
        }
    }

    public static int[] returnNums(int[] nums, int count, int[] targets) {
        int[] countArray = new int[count];

        int sum = 0;

        int[] sort = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            sort[i] = sum;
        }

        for (int i = 0; i < count; i++) {
            countArray[i] = findFirstEqualLarger(sort, targets[i]);
        }
        return countArray;
    }

    // 查找第一个等于或者大于key的元素
    static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }

}

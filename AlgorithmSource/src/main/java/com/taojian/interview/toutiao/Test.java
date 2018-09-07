package com.taojian.interview.toutiao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.minjun.offer.HasSameNum;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-06 20:17
 **/
public class Test {

    public static int temp = 0;
    public static int number = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(countArea(nums, k, t));
    }

    public static int countArea(int[] nums, int k, int t) {

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        if (!TakeOutCount(nums,t,0,right))
            return 0;

        for (int i = 0; i < right; i++) {
            int index = k - 1 + i;
            if (index <= right){
            if (TakeOutCount(nums, t, i, index)) {
                count++;
            }
            }
        }
        return count;

    }

    public static boolean TakeOutCount(int[] nums, int t, int left, int right) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = left; i <= right; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();

            if (entry.getValue() >= t) {
                temp = entry.getKey();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

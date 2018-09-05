package com.taojian.array.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-04 18:28
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 **/
public class MajorityElementII {

    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();
        int[] nums = {3, 2, 3};
        System.out.println(majorityElementII.majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {

        if (nums.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int line = nums.length / 3;

        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(nums[i])) {

                int value = hashMap.get(nums[i]) + 1;
                hashMap.put(nums[i], value);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > line) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}

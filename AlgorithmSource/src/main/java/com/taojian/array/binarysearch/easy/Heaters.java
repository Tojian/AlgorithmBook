package com.taojian.array.binarysearch.easy;

import java.util.Arrays;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-29 00:27
 * <p>
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm
 * all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so
 * that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the
 * minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the
 * houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the
 * houses can be warmed.
 **/
public class Heaters {
    /**
     * @param houses
     * @param heaters
     *
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        // sort
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;
        for (int house : houses) {
            int local = binarySearch(heaters, house);
            radius = Math.max(radius, local);
        }

        return radius;
    }

    public static int binarySearch(int[] heaters, int target) {
        int l = 0, r = heaters.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (heaters[mid] == target) {
                return 0;
            } else if (heaters[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return Math.min(Math.abs(target - heaters[l]), Math.abs(target - heaters[r]));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(binarySearch(nums, 7));
    }
}

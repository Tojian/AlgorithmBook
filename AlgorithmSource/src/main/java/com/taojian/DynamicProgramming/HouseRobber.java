package com.taojian.DynamicProgramming;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-22 16:55
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * 对于n个数的数组，如果要求得其连续不相邻元素的最大值，
 * 那么我们只需求得n-1个数的最大值，以及求得n-2个数的最大值即可，这样就形成了求解该问题的子问题的最大值问题，所
 * 以很容易考虑出递推关系，
 * 假设数组为Arr[]，n个数的数组对应的不相邻连续元素的最大值用函数f(n)表示，则有f
 * (n) = max{f(n-1), f(n-2)+A[n-1]}，其中n>=2，f(n)也称为递推关系。其中f(n-1)为n-1个元素的最大值，
 * f(n-2)+Arr[n-1]为n-2个元素的最大值加上数组第n个元素的值，因为要求元素不能相邻，所以会跳过第n-1个元素
 **/
public class HouseRobber {

    public static int[] result;

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] rt = new int[len];

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                rt[i] = nums[i];
            } else if (i == 1) {
                rt[i] = Math.max(rt[i - 1], nums[i]);
            } else {
                rt[i] = Math.max(rt[i - 1], rt[i - 2] + nums[i]);
            }
        }
        return rt[len - 1] > rt[len - 2] ? rt[len - 1] : rt[len - 2];

    }

    /**
     * 递归
     *
     * @param nums
     *
     * @return
     */

    public static int sovle(int xid, int[] nums) {
        if (xid < 0) {
            return 0;
        }
        if (result[xid] >= 0) {
            return result[xid];
        }
        result[xid] = Math.max(sovle(xid - 2, nums) + nums[xid], sovle(xid - 1, nums));
        return result[xid];
    }

    public static int rob1(int[] nums) {

        return sovle(nums.length - 1, nums);
    }

    public static int rob2(int[] nums) {

        result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        return sovle(nums.length - 1, nums);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
    }
}

package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-16 21:13
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5}
 * 的一个旋转，该数组的最小值为 1。NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 * <p>
 * 解题思路
 * 当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；否则解在 [m + 1, h] 之间，令 l = m + 1。
 * <p>
 * 因为 h 的赋值表达式为 h = m，因此循环体的循环条件应该为 l < h
 * <p>
 * 复杂度：O(logN) + O(1)
 * <p>
 * <p>
 * 对于旋转数组，使用二分法来查找最小元素。
 * 取中间mid元素，如果array[mid]>array[end]，说明最小元素应该在mid的右边，因为我们实际是要找没有旋转之前的第一个元素，
 * 观察数组规律可以知道，在mid的右边
 * 如果array[mid]<array[start]，说明已经取到了被旋转的那一节数组了，因此此时的最小元素，应该在mid的左边
 * 另外有一个特殊情况，就是分不清楚在哪段数组中，也就是恰好有重复元素，那就只能遍历查找了，所以最坏的时间复杂度是O(n)，最好是O(logn)
 **/
public class MinNumberInRotateArray_8 {

    public static void main(String[] args) {
        int [] nums = {4,5,6,2,3,4,4,4,4,4};
        System.out.println(minNumberInRotateArray(nums));
    }



    public static int minNumberInRotateArray(int[] nums) {

        if (nums.length < 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left - right) / 2 + right;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                int cur = left + 1;
                int min = nums[left];
                while (cur <= right) {
                    min = min < nums[cur] ? min : nums[cur];
                    cur++;
                }
                return min;

            }
        }
        return nums[left];
    }


    public int minNumberInRotateArray2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
}

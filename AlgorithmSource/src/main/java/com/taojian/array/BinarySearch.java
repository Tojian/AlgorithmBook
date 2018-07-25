package com.taojian.array;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-25 20:48
 * 二分查找
 **/
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 4, 5, 8, 9};
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearchRecursion(nums, 1, 0, nums.length - 1));
    }

    /**
     * 循环
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums.length < 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left - right) / 2 + right;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     *
     * @return
     */
    public static int binarySearchRecursion(int[] nums, int target, int left, int right) {

        if (nums.length < 0 || left < 0 || right > nums.length - 1) {
            return -1;
        }

        int mid = (left - right) / 2 + right;
        if (left <= right) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                return binarySearchRecursion(nums, target, mid + 1, right);
            } else {
                return binarySearchRecursion(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

    /**
     * findFirstEqual
     */

    // 查找第一个相等的元素
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {

     /*
    （1）写成(i+j)/2，可能会导致求和中间结果的溢出，因为两个32位整数的和是有可能超过32位整数的范围的嘛
    （2）因为四则运算符的优先级高于移位运算符>>，所以可以把mid = i+((j-i)>>1)简化下，不过注意不要写成mid = i+(j-i)>>1哈
    （3）因为移位运算符比直接除快嘛，所以用>>1代替除2
    */
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }

        return -1;
    }


    // 查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }


    // 查找最后一个小于key的元素
    static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
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
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 查找第一个大于key的元素
    static int findFirstLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}

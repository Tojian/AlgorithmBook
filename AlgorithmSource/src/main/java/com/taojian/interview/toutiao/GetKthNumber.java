package com.taojian.interview.toutiao;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-05 14:14
 * <p>
 * 无序数组求k个最大的数字
 **/
public class GetKthNumber {

    public static void main(String[] args) {

    }

    public static int getKthNumber(int[] nums, int kth) {

        int left = 0 ;
        int right = nums.length - 1;

        int index = partition(nums,0,nums.length);
        while (left < right){
            int mid = (left - right)/2 + right;
            if (kth == index + 1)
                return nums[index];
            if (kth > index + 1)
                index = partition(nums,mid + 1,right);
            else index =partition(nums,0,mid - 1);
        }
        return -1;
    }

    public static int partition(int[] nums, int left, int right) {

        int temp = nums[left];

        while (left < right) {

            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];

        }

        nums[left] = temp;
        return left;
    }
}

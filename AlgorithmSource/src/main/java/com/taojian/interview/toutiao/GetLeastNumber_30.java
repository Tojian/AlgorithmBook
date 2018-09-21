package com.taojian.interview.toutiao;

import java.util.ArrayList;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 14:33
 * <p>
 * 一个数组第k个最小的数字
 **/
public class GetLeastNumber_30 {

    public static void main(String[] args) {
        GetLeastNumber_30 getLeastNumber_30 = new GetLeastNumber_30();
        int[] nums = {4, 5, 1, 6, 2, 6, 3, 8};
        ArrayList<Integer> arrayList = getLeastNumber_30.GetLeastNumbers_Solution(nums, 4);

        for (Integer i : arrayList) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrays = new ArrayList<>();
        int left = 0;
        int right = input.length - 1;
        int index = getIndex(input , 0, right);
        while (left <= right){
            int mid = (left - right) / 2 + right;
            if (index + 1  == k )
                break;
            if (index + 1> k)
                index = getIndex(input , left, mid - 1);
            else
                index = getIndex(input , mid + 1, right);
        }
        if ((index + 1) != k)
            return  null;
        for (int i = 0; i < k; i ++){
            arrays.add(input[i]);
        }
        return arrays;
    }

    private int getIndex(int [] input , int left ,int right){
        int p = input[left];

        while (left < right){

            while (left < right && input[right] > p)
                right --;
            input[left] = input[right];

            while(left < right && input[left] < p)
                left ++;
            input[right] = input[left];
        }
        input[left] = p;
        return left;
    }




    public static int indexGetLeastNumber(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);
        while (left <= right) {
            int mid = (left - right) / 2 + right;
            if (index + 1 == k) {
                return nums[index];
            }
            if (index + 1 < k) {
                index = partition(nums, mid + 1, right);
            } else {
                index = partition(nums, left, mid - 1);
            }
        }
        return -1;
    }

    public static int patition(int[] nums, int left, int right) {

        if (nums.length < 0 || left < 0 || right < 0 || left > right) {
            return -1;
        }
        int index = left;
        int temp = nums[left];

        while (left < right) {

            while (left < right && nums[right] > temp) {
                right--;
            }
            swap(nums, left, right);
            while (left < right && nums[left] < temp) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, index, left);
        return left;
    }

    static int partition(int A[], int left, int right) {
        //选择枢纽元素
        int p = A[left];
        while (left < right) {
            //如果尾指针位置的数比枢纽数要大，移动尾指针的位置，否则就把所指示的值给首指针的位置
            while (left < right && A[right] >= p) {
                --right;
            }
            A[left] = A[right];
            //如果首指针位置的数比枢纽数要小，移动首指针的位置，否则就把所指示的值给尾指针的位置
            while (left < right && A[left] <= p) {
                ++left;
            }
            A[right] = A[left];
        }
        //此时的首尾指针已经相等，把枢纽的值赋给首尾指针相等的位置即可
        A[left] = p;
        return left;
    }

    public static void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}

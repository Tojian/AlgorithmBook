package com.taojian.sort;

/**
 * @description: 归并排序
 * @author: taojian
 * @create: 2018-06-26 11:31
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and
 * Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * 5.1 算法描述
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 **/
public class MergeSort {

    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);

        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];

            } else {
                temp[k++] = nums[j++];

            }

        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];

        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];

        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];

        }

    }

}

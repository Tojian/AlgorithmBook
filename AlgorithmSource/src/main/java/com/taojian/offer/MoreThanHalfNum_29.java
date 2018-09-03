package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 16:31
 * <p>
 * 无序数组中出现次数超过一半的数字
 **/
public class MoreThanHalfNum_29 {


    // 解法一o(n):基于快速排序的分割思想：在随机快速排序算法中，我们先在数组中随机选择一个数字，然后调整数组中数字的顺序，使得比选中的数字小的数字排在它的左边，比选中
    // 的数字大的排在它的右边，如果选中的数字的下标刚好是n/2，那么这个数字就是数组的中位数
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null)
            return 0;
        int length = array.length;
        int start = 0;
        int end = length - 1;
        int middle = length >> 2;
        int index = Partition(array, length, start, end);
        // 如果选中的数字的下标刚好是n/2，那么这个数字就是数组的中位数
        while (index != middle) {
            // 如果选中的数字的下标刚好是n/2右边，调整左边数字
            if (index > middle) {
                end = index - 1;
                index = Partition(array, length, start, end);
            } else {
                // 如果选中的数字的下标刚好是n/2左边，调整右边数字
                start = index + 1;
                index = Partition(array, length, start, end);
            }
        }
        // 最后验证这个数字是不是真的超过数组的一半
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[index])
                count++;
        }
        if (count * 2 > array.length)
            return array[index];
        else
            return 0;
    }

    // 在数组中选择一个数，比选择的数字小的数字移到数组的左边，比选择数字大的移动到数组的右边
    static int Partition(int[] data, int length, int start, int end) {
        if (data.length == 0 || length <= 0 || start < 0 || end >= length) {

            return -1;
        }
        // 选择从最后一个数为基准元素开始一次排序
        int index = start - 1;
        for (int i = start; i < end; ++i) {
            if (data[i] < data[end]) // 以最后一个元素为基准点进行划分
            {
                ++index;
                if (index != i) {
                    // 交换
                    int temp = data[i];
                    data[i] = data[index];
                    data[index] = temp;
                }
            }
        }

        ++index;
        // 交换
        int temp = data[index];
        data[index] = data[end];
        data[end] = temp;
        // System.out.print("index=" + index + " ");
        return index; // 返回一次排序后开始选择的数此刻所在最终位置索引

    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 4, 4, 2, 4 };
        System.out.println(MoreThanHalfNum_Solution(array));

    }

}


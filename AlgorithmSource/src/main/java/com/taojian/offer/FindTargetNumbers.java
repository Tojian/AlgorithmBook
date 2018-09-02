package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-14 17:00
 * 4. 二维数组中的查找
 * NowCoder
 *
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 * 解题思路
 * 从右上角开始查找。因为矩阵中的一个数，它左边的数都比它小，下边的数都比它大。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间。
 *
 * 复杂度：O(M + N) + O(1)
 **/
public class FindTargetNumbers {

    public static void main(String[] args) {


    }

    private static boolean findTargetNumbers(int [][] nums , int target ){

     int rows = nums.length;
     int cols = nums[0].length;
     int r = 0;
     int c = cols -1 ;
     while (r <= rows - 1 && c>=0){
         if (target == nums[r][c])
             return true;
         else if (target > nums[r][c])
             r++;
         else
             c--;
     }
        return false;
    }

}

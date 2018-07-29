package com.taojian.array.binarysearch.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-29 10:54
 *
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] >
 *     ... > A[A.length - 1].
 *
 * Example 1:
 *
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 *
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 **/
public class PeakIndexMountainArray {


    public int peakIndexInMountainArray(int[] A) {
        if ( A.length <= 0)
            return -1;
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left - right )/2 + right;
            if (A[mid] >= A[mid-1] && A[mid] >= A[mid+1])
                return mid;
            else if (A[mid] >=A[mid -1] &&A[mid] < A[mid+1] )
                left = mid + 1;
            else if (A[mid] < A[mid-1] && A[mid] >= A[mid+1])
                right = mid - 1;
        }
        return -1;
    }
}

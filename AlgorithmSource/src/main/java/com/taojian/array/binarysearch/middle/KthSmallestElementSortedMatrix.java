package com.taojian.array.binarysearch.middle;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 19:41
 * <p>
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest
 * element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 **/
public class KthSmallestElementSortedMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 5, 7},
                {7, 11, 13},
                {12, 14, 200}
        };

        System.out.println(kthSmallest(matrix,7));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        if (k == 1) {
            return matrix[0][0];
        }
        int n = matrix.length;
        if (k == n * n) {
            return matrix[n - 1][n - 1];
        }
        int min = matrix[0][0], max = matrix[n - 1][n - 1];

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    public static int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        int x = matrix.length - 1, y = 0;
        while (x >= 0 && y < matrix.length) {
            if (matrix[x][y] <= target) {
                y++;
                count += x + 1;
            } else {
                x--;
            }
        }
        return count;
    }
}

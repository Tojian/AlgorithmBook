package com.taojian.array.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 16:37
 *
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of
 * the matrix.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 **/
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {

        int row = A.length;
        int col = A[0].length;
        int total = row*col;

        int[][] result = new int[col][row];
        for(int i=0; i<total; i++) {
            int r = i/row;
            int c = i%row;
            result[r][c] = A[c][r];
        }

        return result;
    }
}

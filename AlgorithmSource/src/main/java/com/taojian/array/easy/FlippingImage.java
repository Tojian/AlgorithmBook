package com.taojian.array.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 17:26
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
 * horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1,
 * 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 *
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 **/
public class FlippingImage {
    public static void main(String[] args) {
        int [][] A={{1,1,0},{1,0,1},{0,0,0}};
        FlippingImage flippingImage = new FlippingImage();
        int [][] flip = flippingImage.flipAndInvertImage(A);

    }
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++){
            int left = 0;
            int right = A[0].length - 1;
            while (left < right){
                int temp = A[i][left];
                A[i][left] =A[i][right];
                A[i][right] = temp;
                left ++;
                right --;
            }
            for (int j = 0; j < A[0].length; j ++){
                if (A[i][j] == 0)
                    A[i][j] = 1;
                else A[i][j] = 0;
            }
        }
        return A;

    }


    private void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}

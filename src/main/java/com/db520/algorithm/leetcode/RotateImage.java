package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * @author zhuyl
 * @version 2019-05-19
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }


    public void rotate(int[][] matrix) {
        int temp = 0;
        int n = matrix.length;
        if(n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i < j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n / 2) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = temp;
                }
            }
        }

    }
}

package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * @author zhuyl
 * @version 2019-05-22
 */
public class SpiralMatrixTwo {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(new SpiralMatrixTwo().generateMatrix(n)));

    }

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        if(matrix.length == 0) {
            return matrix;
        }

        int direct = 1;
        int top = 0;
        int right = 0;
        int bottom = 0;
        int left = 0;
        int index = 1;

        while(index <= n * n) {
            if(direct == 1) {
                if(left > n - 1 - right) {
                    break;
                }
                for (int i = left; i < n - right; i++) {
                    matrix[top][i] = index;
                    index++;
                }
                direct = 2;
                top++;
            }
            if(direct == 2) {
                if(top > n - 1 - bottom) {
                    break;
                }
                for (int i = top; i < n - bottom; i++) {
                    matrix[i][n - 1 - right] = index;
                    index++;
                }
                direct = 3;
                right++;
            }
            if(direct == 3) {
                if(n - 1 - right < left) {
                    break;
                }
                for (int i = n - 1 - right; i >= left; i--) {
                    matrix[n - 1 - bottom][i] = index;
                    index++;
                }
                direct = 4;
                bottom++;
            }
            if(direct == 4) {
                if(n - 1 - bottom < top) {
                    break;
                }
                for (int i = n - 1 - bottom; i >= top; i--) {
                    matrix[i][left] = index;
                    index++;
                }
                direct = 1;
                left++;
            }
        }
        return matrix;

    }

}

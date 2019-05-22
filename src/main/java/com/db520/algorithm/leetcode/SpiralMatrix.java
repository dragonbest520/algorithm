package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * @author zhuyl
 * @version 2019-05-22
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List list = new ArrayList();
        if(matrix.length == 0) {
            return list;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int direct = 1;
        int top = 0;
        int right = 0;
        int bottom = 0;
        int left = 0;
        while(true) {
            if(direct == 1) {
                if(left > n - 1 - right) {
                    break;
                }
                for (int i = left; i < n - right; i++) {
                    list.add(matrix[top][i]);
                }
                direct = 2;
                top++;
            }
            if(direct == 2) {
                if(top > m - 1 - bottom) {
                    break;
                }
                for (int i = top; i < m - bottom; i++) {
                    list.add(matrix[i][n - 1 - right]);
                }
                direct = 3;
                right++;
            }
            if(direct == 3) {
                if(n - 1 - right < left) {
                    break;
                }
                for (int i = n - 1 - right; i >= left; i--) {
                    list.add(matrix[m - 1 - bottom][i]);
                }
                direct = 4;
                bottom++;
            }
            if(direct == 4) {
                if(m - 1 - bottom < top) {
                    break;
                }
                for (int i = m - 1 - bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                direct = 1;
                left++;
            }
        }

        return list;
    }

}

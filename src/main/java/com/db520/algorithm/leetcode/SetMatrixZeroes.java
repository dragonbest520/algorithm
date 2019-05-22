package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * @Author zhuyl
 * @Version 2019-05-22
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new SetMatrixZeroes().setZeroes(matrix);
    }


    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            return;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return;
        }

        List<Integer> rowZero = new ArrayList();
        List<Integer> colZero = new ArrayList();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(!rowZero.contains(i)) {
                        rowZero.add(i);
                    }
                    if(!colZero.contains(j)) {
                        colZero.add(j);
                    }
                }
            }
        }

        for (int i = 0; i < rowZero.size(); i++) {
            for (int j = 0; j < n; j++) {
                matrix[rowZero.get(i)][j] = 0;
            }
        }

        for (int i = 0; i < colZero.size(); i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][colZero.get(i)] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

    }
}

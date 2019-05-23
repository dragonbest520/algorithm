package com.db520.algorithm.leetcode;

/**
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * @author zhuyl
 * @version 2019-05-23
 */
public class Searcha2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix2 = {{1},{3}};
        int target = 13;
        int target2 = 0;
        System.out.println(new Searcha2DMatrix().searchMatrix(matrix2, target2));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
            return false;
        }

        int n = matrix[0].length;
        if(n == 0) {
            return false;
        }

        int mid = m / 2;
        int left = 0;
        int right = m - 1;
        while(left != right && left <= right) {
            mid = (left + right) / 2;
            if(matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                if(matrix[mid][n - 1] >= target) {
                    left = mid;
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }

        if(left == right) {
            for (int i = 0; i < n; i++) {
                if(matrix[left][i] == target) {
                    return true;
                }
            }
        }

        return false;

    }
}

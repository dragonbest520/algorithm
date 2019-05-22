package com.db520.algorithm.leetcode;

/**
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * @Author zhuyl
 * @Version 2019-05-22
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid2 = {{1}};
        System.out.println(new MinimumPathSum().minPathSum(grid2));
    }

    public int minPathSum(int[][] grid) {
        int sum = 0;
        int m = grid.length;
        if(m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if(n == 0) {
            return 0;
        }
        int[][] path = new int[m][n];
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            path[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            path[i][0] = sum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = grid[i][j] + Math.min(path[i][j - 1], path[i - 1][j]);
            }
        }
        return path[m - 1][n - 1];
    }
}

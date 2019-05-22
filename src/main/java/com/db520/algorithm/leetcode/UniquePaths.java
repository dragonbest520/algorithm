package com.db520.algorithm.leetcode;

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * @author zhuyl
 * @version 2019-05-22
 */
public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(new UniquePaths().uniquePaths(m, n));
    }


    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(m == 1) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        int path[][] = new int[m][n];
        path[0][1] = 1;
        path[1][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(path[i - 1][j] == 0) {
                    path[i - 1][j] = 1;
                }
                if(path[i][j - 1] == 0) {
                    path[i][j - 1] = 1;
                }
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}

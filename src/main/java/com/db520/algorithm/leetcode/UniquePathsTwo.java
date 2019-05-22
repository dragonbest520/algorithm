package com.db520.algorithm.leetcode;

/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *  Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * @Author zhuyl
 * @Version 2019-05-22
 */
public class UniquePathsTwo {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new UniquePathsTwo().uniquePathsWithObstacles(obstacleGrid));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if(m == 1) {
            for (int i = 0; i < n; i++) {
                if(obstacleGrid[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            for (int i = 0; i < m; i++) {
                if(obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        int[][] path = new int[m][n];
        boolean hasObstacle = false;
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                hasObstacle = true;
            }
            if(hasObstacle == false) {
                path[i][0] = 1;
            } else {
                path[i][0] = 0;
            }
        }
        hasObstacle = false;
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                hasObstacle = true;
            }
            if(hasObstacle == false) {
                path[0][i] = 1;
            } else {
                path[0][i] = 0;
            }
        }

        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
//                if(obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
//                    path[i][j] = 0;
//                } else if(obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] != 1) {
//                    path[i][j] = path[i][j - 1];
//                } else if(obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] == 1) {
//                    path[i][j] = path[i - 1][j];
//                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
//                }
                if(obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                }
            }
        }
        return path[m - 1][n - 1];
    }
}

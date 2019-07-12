package com.db520.algorithm.leetcode;

/**
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * @Description MaximalRectangle
 * @Author zhuyl
 * @Date 2019/7/12 9:10
 **/
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                height[j] = matrix[i][j] == '0' ? 0 : (1 + height[j]);
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }

    public int largestRectangleArea(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        if(height.length == 1) {
            return height[0];
        }
        int res = 0;
        for (int i = 0; i < height.length; ++i) {
            if (i + 1 < height.length && height[i] <= height[i + 1]) {
                continue;
            }
            int minH = height[i];
            for (int j = i; j >= 0; --j) {
                minH = Math.min(minH, height[j]);
                int area = minH * (i - j + 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    //too slow
    public int maximalRectangle2(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    int result = helper(matrix, i, j, 1, 1);
                    max = Math.max(max, result);
                }
            }
        }
        return max;
    }

    private int helper(char[][] matrix, int y, int x, int width, int height) {
        int area = 1;
        boolean extendX = true;
        boolean extendY = true;
        for (int i = 0; i < height; i++) {
            if(x + width >= matrix[0].length || matrix[y + i][x + width] == '0') {
                extendX = false;
            }
        }
        for (int i = 0; i < width; i++) {
            if(y + height >= matrix.length || matrix[y + height][x + i] == '0') {
                extendY = false;
            }
        }
        if(extendX) {
            int newArea = helper(matrix, y, x, width + 1, height);
            area = Math.max(area, newArea);
        }
        if(extendY) {
            int newArea = helper(matrix, y, x, width, height + 1);
            area = Math.max(area, newArea);
        }
        if(!extendX && !extendY) {
            return width * height;
        }
        return area;
    }
}

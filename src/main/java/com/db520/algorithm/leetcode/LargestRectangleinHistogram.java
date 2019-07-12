package com.db520.algorithm.leetcode;

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * @Description LargestRectangleinHistogram
 * @Author zhuyl
 * @Date 2019/7/12 9:10
 **/
public class LargestRectangleinHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int[] heights2 = {1};
        int[] heights3 = {1, 1};
        int[] heights4 = {0, 9};
        int[] heights5 = {4,2,0,3,2,4,3,4};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights5));
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
}

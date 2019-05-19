package com.db520.algorithm.leetcode;

/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn
 * such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * @Author zhuyl
 * @Version 2019-05-18
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(array));
    }

    public int maxArea(int[] height) {
        if(height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            if((right - left) * Math.min(height[left], height[right]) > maxArea) {
                maxArea = (right - left) * Math.min(height[left], height[right]);
            }
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

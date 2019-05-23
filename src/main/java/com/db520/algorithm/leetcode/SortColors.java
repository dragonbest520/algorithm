package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 75. Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * @author zhuyl
 * @version 2019-05-23
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] nums2 = {2,0,1};
        int[] nums3 = {2,2};
        int[] nums4 = {2,0,2,1,1,0};
        new SortColors().sortColors(nums4);
        System.out.println(Arrays.toString(nums4));
    }


    public void sortColors(int[] nums) {
        if(nums.length == 0) {
            return;
        }

        int red = 0;
        int blue = nums.length - 1;

        for (int i = 0; i <= blue; i++) {
            if(nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;
                red++;
            } else if(nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;
                blue--;
                i--;
            }
        }
    }
}

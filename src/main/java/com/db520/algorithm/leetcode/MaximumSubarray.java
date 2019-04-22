package com.db520.algorithm.leetcode;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * @author zhuyl
 * @version 2019-04-22
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int segmentSum = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            segmentSum = Math.max(nums[i], nums[i] + segmentSum);
            result = Math.max(result, segmentSum);
        }

        return result;

    }
}

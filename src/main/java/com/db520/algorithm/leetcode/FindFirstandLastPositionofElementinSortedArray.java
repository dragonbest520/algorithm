package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * @author zhuyl
 * @version 2019-05-19
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, target)));
    }


    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                int i = mid;
                int j = mid;
                while(i >= left && nums[i] == target) {
                    i--;
                }
                while(j <= right && nums[j] == target) {
                    j++;
                }
                return new int[] {i + 1, j - 1};
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return new int[] {-1, -1};
    }
}

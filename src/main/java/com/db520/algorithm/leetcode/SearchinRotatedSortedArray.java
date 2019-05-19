package com.db520.algorithm.leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).

 * @author zhuyl
 * @version 2019-05-19
 */
public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {1,3};
        System.out.println(new SearchinRotatedSortedArray().search(nums, 0));
    }

    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left <= right) {
            mid = (right + left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < nums[right]) {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return -1;
    }
}

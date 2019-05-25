package com.db520.algorithm.leetcode;

/**
 * 81. Search in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * @author zhuyl
 * @version 2019-05-25
 */
public class SearchinRotatedSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int[] nums2 = {3,1,1};
        int[] nums3 = {1,1,3,1};
        int target = 3;
        System.out.println(new SearchinRotatedSortedArray2().search(nums3, target));
    }


    public boolean search(int[] nums, int target) {
        if(nums.length == 1) {
            if(target == nums[0]) {
                return true;
            } else {
                return false;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left <= right) {
            mid = (right + left) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] < nums[right]) {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if(nums[mid] > nums[right]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}

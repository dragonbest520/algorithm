package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @author zhuyl
 * @version 2019-04-19
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}

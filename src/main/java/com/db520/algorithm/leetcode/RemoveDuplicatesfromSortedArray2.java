package com.db520.algorithm.leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @author zhuyl
 * @version 2019-05-25
 */
public class RemoveDuplicatesfromSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(new RemoveDuplicatesfromSortedArray2().removeDuplicates(nums2));
    }


    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        int index = 0;
        boolean move = true;
        for (int i = 1; i < nums.length; i++) {
            if(nums[index] != nums[i]) {
                nums[++index] = nums[i];
                move = true;
            } else {
                if(move) {
                    nums[++index] = nums[i];
                    move = false;
                }
            }
        }
        return index + 1;
    }
}

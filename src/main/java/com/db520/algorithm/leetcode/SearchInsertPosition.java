package com.db520.algorithm.leetcode;

/**
 * 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * @author zhuyl
 * @version 2019-04-20
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(new SearchInsertPosition().searchInsert2(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target)
                return i;
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

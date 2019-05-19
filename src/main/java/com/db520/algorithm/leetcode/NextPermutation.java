package com.db520.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * @Author zhuyl
 * @Version 2019-05-18
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 3, 2};
        new NextPermutation().nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }


    public void nextPermutation(int[] nums) {
        if(nums != null && nums.length > 1) {
            int i = nums.length - 2;
            while(i >= 0) {
                if(nums[i] < nums[i + 1]) {
                    break;
                } else {
                    i--;
                }
            }

            if(i >= 0) {
                int j = nums.length - 1;
                while(j > i) {
                    if(nums[j] > nums[i]) {
                        nums[j] = nums[j] ^ nums[i];
                        nums[i] = nums[j] ^ nums[i];
                        nums[j] = nums[j] ^ nums[i];
                        break;
                    } else {
                        j--;
                    }
                }
            }

            Arrays.sort(nums, i + 1, nums.length);
        }
    }
}

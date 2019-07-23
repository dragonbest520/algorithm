package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * @Description LongestConsecutiveSequence
 * @Author zhuyl
 * @Date 2019/7/23 10:04
 **/
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {1, 2, 0, 1};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Map<Integer, Boolean> list = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.containsKey(nums[i])) {
                continue;
            } else {
                list.put(nums[i], true);
            }
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {

            int cur = nums[i];
            while (list.containsKey(--cur)) {
                list.remove(cur);
                count++;
            }
            cur = nums[i];
            while (list.containsKey(++cur)) {
                list.remove(cur);
                count++;
            }
            max = Math.max(max, count);
            list.put(nums[i], true);
            count = 1;
        }
        return max;
    }

    //不符合O(n)
    public int longestConsecutive2(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        nums = bubbleSort(nums);
        int max = 1;
        int count = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(last + 1 == nums[i]) {
                count++;
            } else if(last == nums[i]) {
                continue;
            } else {
                count = 1;
            }
            last = nums[i];
            max = Math.max(max, count);
        }
        return max;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return (array);
    }

    public static void swap(int[] array, int x, int y) {
        if(x != y) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }
}

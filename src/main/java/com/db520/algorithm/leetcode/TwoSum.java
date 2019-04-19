package com.db520.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @author zhuyl
 * @version 2019-04-19
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
        //System.out.println(Arrays.toString(new TwoSum().twoSum2(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            numMap.putIfAbsent(nums[i], i);
            if(numMap.containsKey(target - nums[i]) && i != numMap.get(target - nums[i]) ) {
                return new int[] {numMap.get(target - nums[i]), i};
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}

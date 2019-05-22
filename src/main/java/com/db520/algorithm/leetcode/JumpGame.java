package com.db520.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * @author zhuyl
 * @version 2019-05-22
 */
public class JumpGame {

    Map<Integer, Boolean> map = new HashMap();


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        int[] nums3 = {1,1,2,2,0,1,1};
        System.out.println(new JumpGame().canJump(nums3));
    }


    public boolean canJump(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }

        int maxReach = 0;
        int index = 0;

        while(index < nums.length && index <= maxReach) {
            maxReach = Math.max(maxReach, index + nums[index]);
            index++;
        }

        return maxReach >= nums.length - 1;
    }

    // 超时
    public boolean test(int[] nums, int index) {
        if(index >= nums.length - 1) {
            return true;
        }
        if(nums[index] == 0 && index != nums.length - 1) {
            return false;
        }

        if(map.containsKey(index)) {
            return map.get(index);
        }

        int num = nums[index];
        boolean result = false;
        for (int i = 1; i <= num; i++) {
            result = test(nums, index + i);
            if(result) {
                return true;
            }
        }
        map.put(index, result);
        return result;
    }
}

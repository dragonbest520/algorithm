package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * @Author zhuyl
 * @Version 2019-05-18
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] array = {-1,2,1,-4};
        System.out.println(new ThreeSumClosest().threeSumClosest(array, 1));
    }


    public int threeSumClosest(int[] nums, int target) {
        int result = target;
        if (nums != null && nums.length > 2) {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示如果取第i个数作为结果
            for (int i = 0; i < nums.length - 2; ) {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;

                while (j < k) {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] + nums[i] == target) {
                        return target;
                    }
                    // 和大于target
                    else if (nums[j] + nums[k] + nums[i] > target) {
                        if(result == target || Math.abs(nums[j] + nums[k] + nums[i] - target) < Math.abs(result - target)) {
                            result = nums[j] + nums[k] + nums[i];
                        }

                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和小于0
                    else {
                        if(result == target || Math.abs(nums[j] + nums[k] + nums[i] - target) < Math.abs(result - target)) {
                            result = nums[j] + nums[k] + nums[i];
                        }
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }

                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }
        return result;
    }
}

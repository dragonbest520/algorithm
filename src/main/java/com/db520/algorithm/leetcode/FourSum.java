package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * @Author zhuyl
 * @Version 2019-05-18
 */
public class FourSum {

    public static void main(String[] args) {
        int[] array = {-3,-2,-1,0,0,1,2,3};
        System.out.println(Arrays.toString(new FourSum().fourSum(array, 0).toArray()));
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums != null && nums.length > 3) {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示如果取第i个数作为结果
            for (int i = 0; i < nums.length - 3; ) {

                for (int j = i + 1; j < nums.length - 2;) {
                    // 第3个数可能的起始位置
                    int k = j + 1;
                    // 第4个数可能是结束位置
                    int l = nums.length - 1;

                    while (k < l) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        // 如果找到满足条件的解
                        if (sum == target) {
                            // 将结果加入到结果含集中
                            List<Integer> list = new ArrayList<>(3);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            result.add(list);

                            // 移动到下一个位置。找下一组解
                            l--;
                            k++;

                            // 从左向右找第一个与之前处理的数不同的数的下标
                            while (k < l && nums[k] == nums[k - 1]) {
                                k++;
                            }
                            // 从右向左找第一个与之前处理的数不同的数的下标
                            while (k < l && nums[l] == nums[l + 1]) {
                                l--;
                            }
                        }
                        // 和大于0
                        else if (sum > target) {
                            l--;
                            // 从右向左找第一个与之前处理的数不同的数的下标
                            while (k < l && nums[l] == nums[l + 1]) {
                                l--;
                            }
                        }
                        // 和小于0
                        else {
                            k++;
                            // 从左向右找第一个与之前处理的数不同的数的下标
                            while (k < l && nums[k] == nums[k - 1]) {
                                k++;
                            }
                        }
                    }

                    // 指向下一个要处理的数
                    j++;
                    // 从左向右找第一个与之前处理的数不同的数的下标
                    while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }

                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }
}

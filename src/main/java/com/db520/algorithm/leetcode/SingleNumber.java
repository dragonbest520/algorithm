package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * @author zhuyl
 * @version 2019-05-09
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(nums));
        System.out.println(new SingleNumber().singleNumber2(nums));
    }

    public int singleNumber(int[] nums) {
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) {
                list.remove(Integer.valueOf(nums[i]));
            } else {
                list.add(nums[i]);
            }
        }
        return (Integer) list.get(0);
    }

    public int singleNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] ^= nums[i - 1];
        }
        return nums[nums.length - 1];
    }
}

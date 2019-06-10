package com.db520.algorithm.leetcode;

/**
 * 137. Single Number II
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author zhuyl
 * @version 2019-06-10
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3};
        System.out.println(new SingleNumber2().singleNumber2(nums));
    }



    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }


    public int singleNumber2(int[] nums) {

        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; ++i) {
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }


    public int singleNumber3(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }
}

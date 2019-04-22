package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 66. Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * @author zhuyl
 * @version 2019-04-22
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(new PlusOne().plusOne2(nums)));
    }

    public int[] plusOne(int[] digits) {
        boolean largeThan10 = false;
        int result = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            result = digits[i];
            if(i == digits.length - 1) {
                result++;
            }
            if(largeThan10) {
                result++;
            }
            if(result == 10) {
                digits[i] = 0;
                largeThan10 = true;
            } else {
                digits[i] = result;
                largeThan10 = false;
                break;
            }
        }
        if(largeThan10) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}

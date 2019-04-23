package com.db520.algorithm.leetcode;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * @author zhuyl
 * @version 2019-04-23
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 12321;
        System.out.println(new PalindromeNumber().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        int origin = x;
        int result = 0;

        if(x < 0) {
            return false;
        }

        while(x > 0) {
            if(Math.abs(result) > Integer.MAX_VALUE / 10) {
                return false;
            }
            int m = x % 10;
            result = result * 10 + m;
            x = x / 10;
        }

        return (origin == result);
    }
}

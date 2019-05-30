package com.db520.algorithm.leetcode;

/**
 * 125. Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author zhuyl
 * @version 2019-05-30
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = ".,";
        String s3 = "0P";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if(s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !isAlphanumeric(s.charAt(start))) {
                start++;
            }
            while(start <= end && !isAlphanumeric(s.charAt(end))) {
                end--;
            }
            if(start > end) {
                break;
            }
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }

}

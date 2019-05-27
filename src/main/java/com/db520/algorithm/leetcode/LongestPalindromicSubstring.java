package com.db520.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * @author zhuyl
 * @version 2019/5/27
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        if(s.length() < 1) {
            return s;
        }

        String result = s.substring(0);
        int count = 1;
        int i = 0;
        int j = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(i), i);
        while(j < s.length()) {
            if(!isPalindromic(s.substring(i, j))) {
                map.remove(s.charAt(i++));
            } else {
                map.put(s.charAt(j), j);
                j++;
                if(count < j - i) {
                    result = s.substring(i, j);
                    count = j - i;
                }
            }
        }
        return result;
    }

    public boolean isPalindromic(String s) {
        int left = s.length() / 2;
        int right = s.length() / 2;
        if(s.length() % 2 == 0) {
            left = s.length() / 2 - 1;
        } else {
            left = s.length() / 2 - 1;
            right = s.length() / 2 + 1;
        }
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left--;
                right--;
            }
        }
        return true;
    }
}

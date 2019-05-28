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

        /*String t = "$#";
        for (int i = 0; i < s.length(); i++) {
            t += s.charAt(i);
            t += "#";
        }*/

        StringBuilder t = new StringBuilder("$#");
        for (int i = 0; i < s.length(); i++) {
            t.append(s.charAt(i));
            t.append("#");
        }

        int id = 0;
        int resCenter = 0;
        int resLen = 0;
        int mx = 0;
        int[] p = new int[t.length()];
//        for (int j = 0; j < t.length(); j++) {
//            p[j] = 0;
//        }

        for (int i = 1; i < t.length(); i++) {
            p[i] = mx > i ? Math.min(mx - i, p[2 * id - i]) : 1;
            while(i + p[i] < t.length() && t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
            if(mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if(resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }


        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen - 1);
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

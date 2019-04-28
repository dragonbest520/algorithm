package com.db520.algorithm.leetcode;

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * @Author zhuyl
 * @Version 2019-04-25
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","floz","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix2(strs));
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        int commonLength = first.length();
        for (int i = 1; i < strs.length; i++) {
            commonLength = Math.min(commonLength, strs[i].length());
            for (int j = 0; j < commonLength; j++) {
                if(first.charAt(j) != strs[i].charAt(j)) {
                    commonLength = Math.min(commonLength, j);
                }
            }
        }
        return first.substring(0, commonLength);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int j = 0; j < strs[0].length(); ++j) {
            for (int i = 0; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0];
    }
}

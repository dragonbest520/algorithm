package com.db520.algorithm.leetcode;

/**
 * 10. Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * @Description RegularExpressionMatching
 * @Author zhuyl
 * @Date 2019/7/2 11:21
 **/
public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(new RegularExpressionMatching().isMatch2(s, p));
    }

    //recursive
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        //长度大于等于2的时候
        if(p.length() >= 2 && p.charAt(1) == '*') {
            //两种情况
            //pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
            //pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    //DP
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length(); j >= 0; j--) {
                if(i == s.length() && j == p.length()) {
                    continue;
                }
                boolean firstMatch = (i < s.length() && j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}

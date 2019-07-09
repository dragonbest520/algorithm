package com.db520.algorithm.leetcode;

/**
 * 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * @Description WildcardMatching
 * @Author zhuyl
 * @Date 2019/7/6 14:28
 **/
public class WildcardMatching {
    public static void main(String[] args) {
        //String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        //String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        String s = "aa";
        String p = "*";
        System.out.println(new WildcardMatching().isMatch(s, p));
    }

    //recursive timeout
    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        } else {
            //处理连续的*
            while(p.indexOf("**") != -1) {
                p = p.replace("**", "*");
            }
        }

        if (p.charAt(0) == '*') {
            return (isMatch(s, p.substring(1)) || (!s.isEmpty() && isMatch(s.substring(1), p)));
        } else {
            return (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') && isMatch(s.substring(1), p.substring(1)));
        }
    }

    //DP
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length(); j >= 0; j--) {
                if(i == s.length() && j == p.length()) {
                    continue;
                }
                if(j < p.length() && p.charAt(j) == '*') {
                    dp[i][j] = (j + 1 <= p.length() && dp[i][j + 1]) || (i + 1 <= s.length() && dp[i + 1][j]);
                } else {
                    dp[i][j] = (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}

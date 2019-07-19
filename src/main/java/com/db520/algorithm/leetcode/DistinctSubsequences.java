package com.db520.algorithm.leetcode;

/**
 * 115. Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * @Description DistinctSubsequences
 * @Author zhuyl
 * @Date 2019/7/16 9:47
 **/
public class DistinctSubsequences {

    public static void main(String[] args) {
        //String s = "rabbbit", t = "rabbit";
        String s = "babgbag", t = "bag";
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
    }

    //DP
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for(int j=0; j<=s.length(); ++j) {
            dp[t.length()][j] = 1;
        }
        for(int i=t.length()-1; i>=0; i--)
            for(int j=s.length()-1; j>=0; j--){
                // 是否相等都要加上前面的值
                dp[i][j] = dp[i][j+1];
                // 相等时加上，上一个字符匹配得出的结果
                if(s.charAt(j) == t.charAt(i)) {
                    dp[i][j] += dp[i+1][j+1];
                }
            }
        return dp[0][0];
    }

    //recursive Time Limit Exceeded
    public int numDistinct2(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        if (s.length() == t.length() && s.equals(t)) {
            return 1;
        }
        if (t.length() == 0) {
            return 1;
        }
        if (s.charAt(0) != t.charAt(0)) {
            return numDistinct(s.substring(1), t);
        }
        else {
            return numDistinct(s.substring(1), t.substring(1)) + numDistinct(s.substring(1), t);
        }
    }

}

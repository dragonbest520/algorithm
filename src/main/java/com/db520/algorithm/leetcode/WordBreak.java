package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * @author zhuyl
 * @version 2019-06-10
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        String s2 = "leetcode";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("leet");
        wordDict2.add("code");

        String s3 = "cars";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("car");
        wordDict3.add("ca");
        wordDict3.add("rs");


        System.out.println(new WordBreak().wordBreak(s3, wordDict3));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                if(dp[j] && wordDict.contains(tmp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    // TLE
    public boolean wordBreak2(String s, List<String> wordDict) {
        if(s.length() == 0) {
            return true;
        }

        for(String dict : wordDict) {
            if(dict.length() > s.length()) {
                continue;
            } else {
                if(s.substring(0, dict.length()).equals(dict)) {
                    if(wordBreak(s.substring(dict.length()), wordDict)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }

        return false;
    }

}

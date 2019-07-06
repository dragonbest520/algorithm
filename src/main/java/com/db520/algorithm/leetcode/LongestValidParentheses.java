package com.db520.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * @Description LongestValidParentheses
 * @Author zhuyl
 * @Date 2019/7/2 11:24
 **/
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()())";
        String s2 = "(()";
        String s3 = "()(())";
        String s4 = "()(()";
        String s5 = "(()()";
        String s6 = ")()())";
        String s7 = "())";
        System.out.println(new LongestValidParentheses().longestValidParentheses2(s7));
    }

    public int longestValidParentheses(String s) {
        if(s.length() == 0) {
            return 0;
        }
        Stack<Integer> list = new Stack<Integer>();
        int max = 0;
        int num = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                list.push(i);
            } else {
                if(list.isEmpty()) {
                    l = i + 1;
                } else {
                    list.pop();
                    if(list.isEmpty()) {
                        max = Math.max(max, i - l + 1);
                    } else {
                        max = Math.max(max, i - list.peek());
                    }
                }
            }
        }

        return max;
    }


    public int longestValidParentheses2(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + 2;
                }
                if(i - dp[i] >= 0) {
                    dp[i] += dp[i - dp[i]];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

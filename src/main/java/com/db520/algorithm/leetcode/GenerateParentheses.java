package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        int n2 = 1;
        System.out.println(new GenerateParentheses().generateParenthesis(n2));
    }


    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if(n == 0) {
            return resultList;
        }
        dfs(n * 2,  0, "", 0, 0, resultList);
        return resultList;
    }

    public void dfs(int n, int level, String temp, int left, int right, List<String> resultList) {
        if(level == n) {
            resultList.add(temp);
            return;
        }
        String str = "()";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                if(left == n / 2) {
                    continue;
                }
            }
            if(str.charAt(i) == ')') {
                if(left < right + 1) {
                    continue;
                }
            }
            dfs(n,  level + 1, temp + str.charAt(i), str.charAt(i) == '(' ? left + 1 : left, str.charAt(i) == ')' ? right + 1 : right, resultList);
        }
    }
}

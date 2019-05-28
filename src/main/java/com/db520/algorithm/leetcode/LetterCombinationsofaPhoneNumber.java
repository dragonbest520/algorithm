package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations(digits));
    }


    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() == 0) {
            return resultList;
        }
        dfs(digits, dict, 0, "", resultList);
        return resultList;
    }

    public void dfs(String digits, String[] dict, int level, String temp, List<String> resultList) {
        if(level == digits.length()) {
            resultList.add(temp);
            return;
        }
        String str = dict[digits.charAt(level) - '0'];
        for (int i = 0; i < str.length(); i++) {
            dfs(digits, dict, level + 1, temp + str.charAt(i), resultList);
        }
    }
}

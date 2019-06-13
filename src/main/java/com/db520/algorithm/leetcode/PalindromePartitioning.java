package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * @author zhuyl
 * @version 2019-06-13
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        String s2 = "cdd";
        System.out.println(new PalindromePartitioning().partition(s2));
    }


    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        dfs(s, new ArrayList<>(), resultList);
        return resultList;
    }

    public void dfs(String s, List<String> list, List<List<String>> resultList) {
        if(s.length() == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String tmp = s.substring(0, i);
            if(isPalindrome(tmp)) {
                list.add(tmp);
                dfs(s.substring(i), list, resultList);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        if(s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}

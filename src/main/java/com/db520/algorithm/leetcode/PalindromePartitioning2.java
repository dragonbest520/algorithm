package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 132. Palindrome Partitioning II
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * @Description PalindromePartitioning2
 * @Author zhuyl
 * @Date 2019/7/23 10:05
 **/
public class PalindromePartitioning2 {

    public static void main(String[] args) {
        String s = "aab";
        String s2 = "cdd";
        String s3 = "ababababababababababababcbabababababababababababa";
        System.out.println(new PalindromePartitioning2().minCut(s));
    }

    /**
	 * 基本思想是使用两个DP数组：
	 * 使用isPalindrome[i，j]来记录 s[i, j]是否为回文串，
	 * 以及num[i]来记录对于s[0，i]的最小划分。
	 * 这里s[i，j]代表的含义是：s.substring（i，j+1）。
	 * 遍历访问数组以计算：num 和 ispalindrome。
	 * num[s.length（）-1]是我们想要的结果。
	 * 注意，如果s[0，i]是回文串，那么num[i]等于零，因为我们不需要划分它来得到回文序列。
	 **/
    public int minCut(String s) {
        char str[] = s.toCharArray();
        boolean isPalindrome[][] = new boolean[s.length()][s.length()];
        int num[] = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j <= i; j++) {
                if(str[i] == str[j] && (j + 1 >= i || isPalindrome[j + 1][i - 1])){
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, num[j - 1] + 1);
                }
            }
            num[i] = min;
        }
        return num[s.length() - 1];
    }

    int min = Integer.MAX_VALUE;
    //TLE
    public int minCut2(String s) {
        dfs(s, new ArrayList<>());
        return min;
    }

    public void dfs(String s, List<String> list) {
        if(s.length() == 0) {
            if(list.size() - 1 < min) {
                min = list.size() - 1;
            }
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String tmp = s.substring(0, i);
            if(isPalindrome(tmp)) {
                list.add(tmp);
                dfs(s.substring(i), list);
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

package com.db520.algorithm.leetcode;

/**
 * 28. Implement strStr()
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @Author zhuyl
 * @Version 2019-04-25
 */

public class ImplementstrStr {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";
        System.out.println(new ImplementstrStr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }
        int res = -1;
        int index = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if(index == needle.length()) {
                return res;
            }
            if(haystack.charAt(i) == needle.charAt(index)) {
                if(res == -1) {
                    res = i;
                }
                index++;
            } else {
                if(res != -1) {
                    i = res;
                }
                index = 0;
                res = -1;
            }
        }
        if(index != needle.length()) {
            res = -1;
        }
        return res;
    }


    public int strStr2(String haystack, String needle) {
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        return -1;
    }
}

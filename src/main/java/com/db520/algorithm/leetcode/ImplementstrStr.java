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
        System.out.println(new ImplementstrStr().strStr2(haystack, needle));
        System.out.println(new ImplementstrStr().strStrKMP(haystack, needle));
        System.out.println(new ImplementstrStr().strStrBM(haystack, needle));
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
        if(needle.equals("")) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if(i + needle.length() > haystack.length()) {
                return -1;
            }

            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if(needle.charAt(j) == haystack.charAt(m))
                {
                    if(j == needle.length() - 1) {
                        return i;
                    }
                    m++;
                } else {
                    break;
                }

            }
        }

        return -1;
    }

    // KMP算法
    public int strStrKMP(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }

        // 计算next数组
        int[] next = new int[needle.length()];
        next[0] = -1;
        int m = -1;
        int n = 0;
        while(n < needle.length() - 1) {
            if(m == -1 || needle.charAt(m) == needle.charAt(n)) {
                m++;
                n++;
                next[n] = m;
            } else {
                m = next[m];
            }
        }

        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == needle.length()) {
            return i - j;
        }

        return -1;
    }

    // BM算法
    public int strStrBM(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }

        if(needle.length() > haystack.length()) {
            return -1;
        }

        int i = needle.length() - 1;
        int j = i;
        String goodSuffix = "";
        while(j < haystack.length()) {
            if(needle.charAt(i) != haystack.charAt(j)) {
                int moveStep = i - needle.lastIndexOf(haystack.charAt(j));
                j += moveStep;
            } else {
                goodSuffix = needle.charAt(i) + goodSuffix;
                if(i == 0) {
                    return j;
                }
                i--;
                j--;
            }
        }
        return -1;
    }

    // Sunday算法
    public int strStrSunday(String haystack, String needle) {
        return -1;
    }
}

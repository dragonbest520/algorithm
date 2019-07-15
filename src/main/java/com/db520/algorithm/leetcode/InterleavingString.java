package com.db520.algorithm.leetcode;

/**
 * 97. Interleaving String
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * @Description InterleavingString
 * @Author zhuyl
 * @Date 2019/7/15 9:48
 **/
public class InterleavingString {

    public static void main(String[] args) {
        //true
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        //false
        //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        //false
        //String s1 = "a", s2 = "b", s3 = "a";
        //true
        //String s1 = "", s2 = "", s3 = "";
        //true
        //String s1 = "a", s2 = "", s3 = "a";
        //false
        //String s1 = "", s2 = "abc", s3 = "ab";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
        result[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0)
                    result[i][j] = true;
                else if (j == 0) {
                    result[i][0] = result[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else if (i == 0) {
                    result[0][j] = result[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else {
                    if (result[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        result[i][j] = true;
                    else if (result[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        result[i][j] = true;
                }

            }
        }
        return result[s1.length()][s2.length()];
    }


    //recursive timeout
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return helper(s1, s2, s1, s2, s3);
    }

    public boolean helper(String originS1, String originS2, String s1, String s2, String s3) {
        if (s3.length() == 0) {
            if (originS1.length() == 0 || originS2.length() == 0) {
                return true;
            }
            if (originS1.length() != s1.length() && originS2.length() != s2.length()) {
                return true;
            } else {
                return false;
            }
        }

        boolean result = false;
        if (s1.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
            result = result || helper(originS1, originS2, s1.substring(1), s2, s3.substring(1));
        }
        if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
            result = result || helper(originS1, originS2, s1, s2.substring(1), s3.substring(1));
        }

        return result;
    }
}

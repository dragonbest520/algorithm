package com.db520.algorithm.leetcode;

/**
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class DecodeWays {

    public static void main(String[] args) {
        String s = "12";
        String s2 = "226";
        String s3 = "0";
        String s4 = "012";
        String s5 = "101";
        System.out.println(new DecodeWays().numDecodings(s5));
    }


    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] number = new int[s.length() + 1];
        number[0] = 1;
        number[1] = 1;
        int tmp;
        for (int i = 2; i <= s.length(); i++) {
            //检查当前字符是不是'0'
            tmp = Integer.parseInt(s.substring(i - 1, i));
            if (tmp != 0) {
                number[i] = number[i - 1];
            }
            //检查当前字符和前一个字符组合在一起是否在1-26之间
            if (s.charAt(i - 2) != '0') {
                tmp = Integer.parseInt(s.substring(i - 2, i));
                if (tmp > 0 && tmp <= 26) {
                    number[i] += number[i - 2];
                }
            }
        }
        return number[s.length()];
    }
}

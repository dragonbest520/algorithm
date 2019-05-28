package com.db520.algorithm.leetcode;

/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String s3 = "ABCD";
        int numRows3 = 3;
        System.out.println(new ZigZagConversion().convert(s3, numRows3));
    }

    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows <= 1) {
            return s;
        }
        int r0 = (s.length() - 1) / (2 *(numRows - 1));
        StringBuilder stringResult = new StringBuilder();

        int level = 0;
        while(level < numRows) {
            for (int i = 0; i <= r0 + 1; i++) {
                int c1 = i * 2 * (numRows - 1) - level;
                int c2 = i * 2 * (numRows - 1) + level;
                if(c1 >= 0 && c1 < s.length() && level != 0 && level != numRows - 1) {
                    stringResult.append(s.charAt(c1));
                }
                if(c2 >= 0 && c2 < s.length()) {
                    stringResult.append(s.charAt(c2));
                }
            }
            level++;
        }

        return stringResult.toString();
    }
}

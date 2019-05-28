package com.db520.algorithm.leetcode;

/**
 * 12. Integer to Roman
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class IntegertoRoman {

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(new IntegertoRoman().intToRoman(num));
    }


    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int n1 = num / 1000;
        for (int i = 0; i < n1; i++) {
            stringBuilder.append("M");
        }

        num = num - n1 * 1000;
        int n2 = num / 100;
        if(n2 == 9) {
            stringBuilder.append("CM");
        } else if(n2 < 9 && n2 >= 5) {
            stringBuilder.append("D");
            for (int i = 0; i < n2 - 5; i++) {
                stringBuilder.append("C");
            }
        } else if(n2 == 4) {
            stringBuilder.append("CD");
        } else if(n2 < 4) {
            for (int i = 0; i < n2; i++) {
                stringBuilder.append("C");
            }
        }

        num = num - n2 * 100;
        int n3 = num / 10;
        if(n3 == 9) {
            stringBuilder.append("XC");
        } else if(n3 < 9 && n3 >= 5) {
            stringBuilder.append("L");
            for (int i = 0; i < n3 - 5; i++) {
                stringBuilder.append("X");
            }
        } else if(n3 == 4) {
            stringBuilder.append("XL");
        } else if(n3 < 4) {
            for (int i = 0; i < n3; i++) {
                stringBuilder.append("X");
            }
        }

        int n4 = num - n3 * 10;
        if(n4 == 9) {
            stringBuilder.append("IX");
        } else if(n4 < 9 && n4 >= 5) {
            stringBuilder.append("V");
            for (int i = 0; i < n4 - 5; i++) {
                stringBuilder.append("I");
            }
        } else if(n4 == 4) {
            stringBuilder.append("IV");
        } else if(n4 < 4) {
            for (int i = 0; i < n4; i++) {
                stringBuilder.append("I");
            }
        }

        return stringBuilder.toString();
    }
}

package com.db520.algorithm.leetcode;

/**
 * 8. String to Integer (atoi)
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class StringtoInteger {

    public static void main(String[] args) {
        String str = "   -42";
        String str2 = "4193 with words";
        String str3 = "words and 987";
        String str4 = "-91283472332";
        String str5 = "+-1";
        String str6 = "42";
        String str7 = "  +0 123";
        String str8 = "2147483648";
        String str9 = "- 234";
        System.out.println(new StringtoInteger().myAtoi(str9));
    }


    public int myAtoi(String str) {
        int result = 0;
        int symbol = 0;
        boolean isNum = false;
        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            if(tempChar == ' ') {
                if(isNum) {
                    break;
                }
                continue;
            } else if(tempChar == '+') {
                if(isNum) {
                    break;
                }
                if(symbol != 0) {
                    return 0;
                } else {
                    symbol = 1;
                }
                isNum = true;
            } else if(tempChar == '-') {
                if(isNum) {
                    break;
                }
                if(symbol != 0) {
                    return 0;
                } else {
                    symbol = -1;
                }
                isNum = true;
            } else if(tempChar >= '0' && tempChar <= '9' ) {
                isNum = true;
                int temp = Integer.parseInt(tempChar + "");
                if(result > (Integer.MAX_VALUE - temp) / 10) {
                    if(symbol == 1 || symbol == 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + temp;
            } else {
                break;
            }
        }
        if(symbol == 0) {
            symbol = 1;
        }
        return result * symbol;
    }
}

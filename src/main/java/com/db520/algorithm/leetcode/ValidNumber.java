package com.db520.algorithm.leetcode;

/**
 * 65. Valid Number
 *
 * Validate if a given string can be interpreted as a decimal number.
 *
 * @Description ValidNumber
 * @Author zhuyl
 * @Date 2019/7/9 11:33
 **/
public class ValidNumber {

    public static void main(String[] args) {
        String s = "53.5e93";
        String s2 = "-+53.5";
        String s3 = "e9";
        String s4 = "1 ";
        String s5 = " ";
        String s6 = ".1";
        String s7 = ".";
        String s8 = "0e";
        String s9 = "3.";
        String s10 = "3.5e+3.5e+3.5";
        String s11 = "4e+";
        String s12 = "+.8";
        System.out.println(new ValidNumber().isNumber(s12));
    }

    public boolean isNumber(String s) {
        String pre = "";
        String post = "";
        s = s.trim();
        if(s.isEmpty()) {
            return false;
        }
        if(s.startsWith("e") || s.endsWith("e")) {
            return false;
        }
        int len = s.split("e").length;
        if(len > 0) {
            pre = s.split("e")[0];
        }
        if(len == 2) {
            post = s.split("e")[1];
        }
        if(len > 2) {
            return false;
        }
        boolean result = isDecimal(pre) && isInt(post);
        return result;
    }

    public boolean isDecimal(String s) {
        if(s.isEmpty()) {
            return true;
        }
        boolean symbol = false;
        boolean pointer = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') {
                if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                    if(symbol == true || i != 0 || i == s.length() - 1) {
                        return false;
                    }
                    symbol = true;
                } else if(s.charAt(i) == '.') {
                    if(i != 0) {
                        if(pointer == true || ((s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-') && i == s.length() - 1)) {
                            return false;
                        }
                    } else {
                        if(i == s.length() - 1) {
                            return false;
                        }
                    }
                    pointer = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isInt(String s) {
        if(s.isEmpty()) {
            return true;
        }
        boolean symbol = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') {
                if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                    if(symbol == true || i != 0 || i == s.length() - 1) {
                        return false;
                    }
                    symbol = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}

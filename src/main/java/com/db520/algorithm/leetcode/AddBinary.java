package com.db520.algorithm.leetcode;

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * @Author zhuyl
 * @Version 2019-04-25
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new AddBinary().addBinary2(a, b));
    }
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        String result = "";

        //位数少的用0补齐
        int supply = Math.abs(a.length() - b.length());
        String supplyStr = "";
        for (int i = 0; i < supply; i++) {
            supplyStr += "0";
        }

        if(a.length() > b.length()) {
            b = supplyStr + b;
        }
        if(a.length() < b.length()) {
            a = supplyStr + a;
        }

        boolean isAdd = false;
        for (int i = length - 1; i >= 0; i--) {
            if(a.charAt(i) != b.charAt(i)) {
                if(isAdd) {
                    result = "0" + result;
                } else {
                    result = "1" + result;
                }
            } else if(a.charAt(i) == '0') {
                if(isAdd) {
                    result = "1" + result;
                    isAdd = false;
                } else {
                    result = "0" + result;
                }
            } else {
                if(isAdd) {
                    result = "1" + result;
                } else {
                    result = "0" + result;
                    isAdd = true;
                }
            }
        }

        if(isAdd) {
            result = "1" + result;
        }
        return result;
    }

    public String addBinary2(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        String res = "";
        // the final length of the result depends on the bigger length between a and b,
        // (also the value of carry, if carry = 1, add "1" at the head of result, otherwise)
        int maxLen = Math.max(m, n);
        for (int i = 0; i < maxLen; i++) {
            // start from last char of a and b
            // notice that left side is int and right side is char
            // so we need to  minus the decimal value of '0'
            int p=0,q=0;
            if(i<m)
                p = a.charAt(m-1-i) - '0';
            else
                p = 0;

            if(i<n)
                q = b.charAt(n-1-i)-'0';
            else
                q = 0;

            int tmp = p + q + carry;
            carry = tmp / 2;
            res = tmp % 2 + res;
        }
        return (carry == 0) ? res : "1" + res;
    }
}

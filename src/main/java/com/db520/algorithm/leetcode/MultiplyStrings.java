package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "2", num2 = "3";
        System.out.println(new MultiplyStrings().multiply2(num1, num2));

    }

    public String multiply(String num1, String num2) {
        List<String> tempList = new ArrayList<>();

        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int maxLen = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = Integer.parseInt(num1.charAt(i) + "");
                int n2 = Integer.parseInt(num2.charAt(j) + "");
                int z1 = num1.length() - i - 1;
                int z2 = num2.length() - j - 1;
                StringBuilder temp = new StringBuilder(n1 * n2 + "");
                for (int k = 0; k < z1 + z2; k++) {
                    temp.append("0");
                }
                maxLen = maxLen < temp.length() ? temp.length() : maxLen;
                tempList.add(temp.toString());
            }
        }

        int sum = 0;
        int add = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {

            for (int j = 0; j < tempList.size(); j++) {
                if(tempList.get(j).length() - 1 - i >= 0) {
                    sum += Integer.parseInt(tempList.get(j).charAt(tempList.get(j).length() - 1 - i) + "");
                }
            }
            add = sum / 10;
            result.insert(0, sum % 10 + "");
            sum = add;
        }
        if(add != 0) {
            result.insert(0, add + "");
        }

        return result.toString();
    }


    public String multiply2(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;
            sb.insert(0, digit);
            if (i < d.length - 1)
                d[i + 1] += carry;
        }
        //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

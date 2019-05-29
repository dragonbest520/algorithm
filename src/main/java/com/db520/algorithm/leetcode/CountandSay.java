package com.db520.algorithm.leetcode;

/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * @author zhuyl
 * @version 2019-05-29
 */
public class CountandSay {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new CountandSay().countAndSay(n));
    }


    public String countAndSay(int n) {
        if(n == 0) {
            return "";
        } else if(n == 1) {
            return "1";
        } else {
            String last = countAndSay(n - 1);
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (int i = 0; i < last.length(); i++) {
                num++;
                if(i + 1 == last.length() || (i + 1 < last.length() && last.charAt(i + 1) != last.charAt(i))) {
                    result.append(num).append(last.charAt(i));
                    num = 0;
                }
            }
            return result.toString();
        }
    }
}



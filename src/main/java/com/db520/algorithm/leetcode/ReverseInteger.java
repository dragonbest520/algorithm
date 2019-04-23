package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * @author zhuyl
 * @version 2019-04-23
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(new ReverseInteger().reverse2(x));
    }

    public int reverse(int x) {
        int result = 0;
        int temp = 1;
        if(x < 0) {
            temp = -1;
        }

        x = Math.abs(x);

        List<Integer> list = new ArrayList();

        while(x > 0) {
            list.add(x % 10);
            x = x / 10;
        }

        for (int j = 0; j < list.size(); j++) {
            result += (int)(list.get(j) * Math.pow(10, list.size() - j - 1));
        }

        if(result < 0) {
            return 0;
        }

        return result * temp;
    }

    public int reverse2(int x) {
        int result = 0;
        int temp = 1;
        if(x < 0) {
            temp = -1;
        }

        x = Math.abs(x);

        while(x > 0) {
            if(Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int m = x % 10;
            result = result * 10 + m;
            x = x / 10;
        }

        return result * temp;
    }
}

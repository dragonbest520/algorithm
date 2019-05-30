package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 29. Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * @author zhuyl
 * @version 2019-05-30
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        int dividend2 = 7;
        int divisor2 = -3;
        int dividend3 = 2;
        int divisor3 = 2;
        int dividend4 = -2147483648;
        int divisor4 = -1;
        System.out.println(new DivideTwoIntegers().divide(dividend4, divisor4));
    }

    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
    // operate with long numbers rather than int
    public long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;

        // Return if nothing to divide
        if (dividend < divisor) return 0;

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
    }
}

package com.db520.algorithm.leetcode;

/**
 * 69. Sqrt(x)
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * @Author zhuyl
 * @Version 2019-04-25
 */
public class Sqrtx {

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(11));
        System.out.println(new Sqrtx().mySqrt2(11));
    }

    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }

        int left = 0;
        int right = x;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(x / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt2(int x) {
        if(x <= 1) {
            return x;
        }
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}

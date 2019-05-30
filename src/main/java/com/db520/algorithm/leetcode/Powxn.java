package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * @author zhuyl
 * @version 2019-05-30
 */
public class Powxn {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        double x2 = 0.00001;
        int n2 = 2147483647;
        double x3 = 0.00001;
        int n3 = -2147483648;
        System.out.println(new Powxn().myPow(x3, n3));
    }


    public double myPow(double x, int n) {
        int symbol = 1;
        boolean min = false;
        List<Integer> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        double res = 1;
        if(n == 0) {
            return 1;
        }

        if(n == Integer.MIN_VALUE) {
            min = true;
            n = n + 1;
        }

        if(n < 0) {
            n = n * -1;
            symbol = -1;
        }

        list1.add(1);
        list2.add(x);
        int temp = 1;
        while(temp <= n / 2) {
            temp = temp * 2;
            list1.add(temp);
            list2.add(list2.get(list2.size() - 1) * list2.get(list2.size() - 1) );
        }

        for (int i = list1.size() - 1; i >= 0 && n >= 0; i--) {
            if(n >= list1.get(i)) {
                res = res * list2.get(i);
                n = n - list1.get(i);
            }
        }

        if(symbol == -1) {
            res = 1 / res;
        }

        if(min) {
            res = res / x;
        }

        return res;
    }

    //超时
    public double myPow2(double x, int n) {
        double res = 1;
        if(n == 0) {
            return 1;
        } else if(n > 0) {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
        } else if(n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                res = res * x;
            }
            res = 1 / res;
        }
        return res;
    }
}

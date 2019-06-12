package com.db520.algorithm.leetcode;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @author zhuyl
 * @version 2019-06-12
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(new ClimbingStairs().climbStairs(n));
    }

    public int climbStairs(int n) {
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            helper(i, result);
        }
        return result[n - 1];
    }




    public int helper(int n, int[] result) {
        if(n <= 2) {
            result[n - 1] = n;
            return n;
        }

        if(result[n - 1] == 0) {
            result[n - 1] = helper(n - 1, result) + helper(n - 2, result);
        }
        return result[n - 1];
    }
}

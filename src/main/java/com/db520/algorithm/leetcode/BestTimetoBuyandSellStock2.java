package com.db520.algorithm.leetcode;

/**
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * @author zhuyl
 * @version 2019-04-23
 */
public class BestTimetoBuyandSellStock2 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(new BestTimetoBuyandSellStock2().maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }

        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if(temp > 0) {
                result += temp;
            }
        }
        return result;
    }

}

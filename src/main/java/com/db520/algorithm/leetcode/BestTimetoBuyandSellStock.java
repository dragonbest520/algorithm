package com.db520.algorithm.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * @author zhuyl
 * @version 2019-04-23
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(new BestTimetoBuyandSellStock().maxProfit2(prices));
    }


    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[i] - prices[j];
                if(temp < 0 && temp < result) {
                    result = temp;
                }
            }
        }
        return -result;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(prices[i] - min, result);
        }
        return result;
    }

}

package com.db520.algorithm.leetcode;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * @Description BestTimetoBuyandSellStock3
 * @Author zhuyl
 * @Date 2019/7/16 9:47
 **/
public class BestTimetoBuyandSellStock3 {

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        //int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new BestTimetoBuyandSellStock3().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int psize = prices.length;
        if(psize < 2){
            return 0;
        }

        int[] forward = new int[psize];
        int[] backward = new int[psize];
        int minPrice = prices[0];
        int maxPrice = prices[psize-1];
        int profit = 0;

        for(int i=1; i<psize; i++){
            forward[i] = Math.max(prices[i]-minPrice, forward[i-1]);
            minPrice = prices[i]<minPrice ? prices[i]:minPrice;
        }
        for(int i=psize-2; i>=0; i--){
            backward[i] = Math.max(maxPrice-prices[i], backward[i+1]);
            maxPrice = prices[i]>maxPrice ? prices[i]:maxPrice;
        }
        for(int i=0; i<psize; i++){
            profit = profit>(forward[i]+backward[i]) ? profit:forward[i]+backward[i];
        }
        return profit;
    }

    //too slow
    public int maxProfit2(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[i - 1]) {
                continue;
            }
            max = Math.max(max, maxProfit2(prices, 0, i) + maxProfit2(prices, i - 1, prices.length));
        }
        return max;
    }

    public int maxProfit2(int[] prices, int start, int end) {
        if(end - start == 0) {
            return 0;
        }
        int min = prices[start];
        int result = 0;

        for (int i = start + 1; i < end; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(prices[i] - min, result);
        }
        return result;
    }

}

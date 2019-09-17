package com.tobias.leetcode.array;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 *
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 *
 * Return the maximum profit you can make.
 *
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee714 {


  public int maxProfitByDPWithVariable(int[] prices, int fee) {
    int dpHold = Integer.MIN_VALUE, dpUnHold = 0;
    for (int price : prices) {
      dpUnHold = Math.max(dpUnHold, dpHold + price);
      dpHold = Math.max(dpHold, dpUnHold - price - fee);
    }
    return dpUnHold;
  }


    public int maxProfitByDPWithArray(int[] prices, int fee) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int[][] dp = new int[prices.length][2];
    for (int i = 0; i < prices.length; i++) {
      if (i -1 < 0) {
        dp[i][0] = 0;
        dp[i][1] = -prices[i];
        continue;
      }
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[prices.length - 1][0];
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStockWithTransactionFee714 bestTimeToBuyAndSellStockWithTransactionFee714 = new BestTimeToBuyAndSellStockWithTransactionFee714();
    System.out.println(bestTimeToBuyAndSellStockWithTransactionFee714.maxProfitByDPWithVariable(new int[]{1, 3, 2, 8, 4, 9}, 2));
  }
}

package com.tobias.leetcode.array;

/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock
 * before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2 Output: 2 Explanation: Buy on day 1 (price = 2) and sell on day 2 (price =
 * 4), profit = 4-2 = 2. Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2 Output: 7 Explanation: Buy on day 2 (price = 2) and sell on day 3
 * (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3),
 * profit = 3-0 = 3.
 */
public class BestTimeToBuyAndSellStockIV188 {

  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int[][][] dp = new int[prices.length][k + 1][2];
    for (int i = 0; i < prices.length; i++) {
      for (int ki = k; ki >= 1; ki--) {
        if (i - 1 < 0) {
          dp[i][k][0] = 0;
          dp[i][k][1] = -prices[i];
          continue;
        }
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
      }
    }
    return dp[prices.length - 1][k][0];
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStockIV188 bestTimeToBuyAndSellStockIV188 = new BestTimeToBuyAndSellStockIV188();
    System.out.println(bestTimeToBuyAndSellStockIV188.maxProfit(2, new int[]{2, 4, 1}));
    System.out.println(bestTimeToBuyAndSellStockIV188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));

  }
}

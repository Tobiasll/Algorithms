package com.tobias.leetcode.array;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4] Output: 6 Explanation: Buy on day 4 (price = 0) and sell on day 6 (price
 * = 3), profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1
 * = 3. Example 2:
 *
 * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5),
 * profit = 5-1 = 4. Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again. Example 3:
 *
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max profit =
 * 0.
 */
public class BestTimeToBuyAndSellStockIII123 {

  public int maxProfit3(int[] prices) {
    int dpi20 = 0, dpi21 = Integer.MIN_VALUE, dpi10 = 0, dpi11 = Integer.MIN_VALUE;
    for (int price : prices) {
      dpi20 = Math.max(dpi20, dpi21 + price);
      dpi21 = Math.max(dpi21, dpi10 - price);
      dpi10 = Math.max(dpi10, dpi11 + price);
      dpi11 = Math.max(dpi11, -price);
    }
    return dpi20;
  }

  public int maxProfit2(int[] prices) {
    int[][][] dp = new int[prices.length][3][2];
    for (int i = 0; i < prices.length; i++) {
      if (i - 1 < 0) {
        dp[i][2][0] = 0;
        dp[i][2][1] = -prices[i];
        dp[i][1][0] = 0;
        dp[i][1][1] = -prices[i];
        continue;
      }
      dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
      dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
      dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
      dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
    }
    return dp[prices.length - 1][2][0];
  }

  public int maxProfit1(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int[][][] dp = new int[prices.length][3][2];
    for (int i = 0; i < prices.length; i++) {
      for (int k = 2; k >= 1; k--) {
        if (i - 1 < 0) {
          dp[i][k][0] = 0;
          dp[i][k][1] = -prices[i];
          continue;
        }
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
      }

    }

    return dp[prices.length - 1][2][0];
  }


  public static void main(String[] args) {
    BestTimeToBuyAndSellStockIII123 bestTimeToBuyAndSellStockIII123 = new BestTimeToBuyAndSellStockIII123();
    System.out
        .println(bestTimeToBuyAndSellStockIII123.maxProfit3(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    System.out.println(bestTimeToBuyAndSellStockIII123.maxProfit3(new int[]{1, 2, 3, 4, 5}));
    System.out.println(bestTimeToBuyAndSellStockIII123.maxProfit3(new int[]{7, 6, 4, 3, 1}));
  }
}

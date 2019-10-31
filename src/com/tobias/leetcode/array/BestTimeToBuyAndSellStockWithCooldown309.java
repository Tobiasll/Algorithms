package com.tobias.leetcode.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before
 * you buy again). After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown309 {

  public int maxProfitByDPWithVariable(int[] prices) {
    int dpi0 = 0, dpi1 = Integer.MIN_VALUE, dpi2 = 0;

    for (int price : prices) {
      int temp = dpi0;
      dpi0 = Math.max(dpi0, dpi1 + price);
      dpi1 = Math.max(dpi1, dpi2 - price);
      dpi2 = temp;
    }

    return dpi0;
  }


  public int maxProfitByDPWithArray(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int i = 0; i < prices.length; i++) {
      if (i - 1 == -1) {
        dp[i][0] = 0;
        dp[i][1] = -prices[i];
        continue;
      }
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      if (i - 2 < 0) {
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        continue;
      }
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
    }
    return dp[prices.length - 1][0];
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStockWithCooldown309 bestTimeToBuyAndSellStockWithCooldown309 = new BestTimeToBuyAndSellStockWithCooldown309();
    System.out.println(
        bestTimeToBuyAndSellStockWithCooldown309.maxProfitByDPWithArray(new int[]{1, 2, 3, 0, 2}));
  }
}

package com.tobias.leetcode.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown309 {


  public int maxProfit(int[] prices) {
    int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
    for (int i = 1; i < prices.length; i++) {
      s1 = Math.max(s1, s1 - prices[i]);
      s2 = Math.max(s2, s1 + prices[i]);
      s3 = Math.max(s3, s2 + prices[i]);
      s4 = Math.max(s4, s3 + prices[i]);
    }
    return Math.max(0, s4);
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStockWithCooldown309 bestTimeToBuyAndSellStockWithCooldown309 = new BestTimeToBuyAndSellStockWithCooldown309();
    System.out.println(bestTimeToBuyAndSellStockWithCooldown309.maxProfit(new int[]{1,2,3,0,2}));
  }
}

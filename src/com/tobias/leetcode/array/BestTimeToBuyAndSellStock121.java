package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share
 * of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price =
 * 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs to be larger than buying price. Example
 * 2:
 *
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max profit =
 * 0.
 */
public class BestTimeToBuyAndSellStock121 {

  public int maxProfitByDPWithVariable(int[] prices) {
    int dpHold = Integer.MIN_VALUE, dpUnhold = 0;
    for (int price : prices) {
      dpUnhold = Math.max(dpUnhold, dpHold + price);
      dpHold = Math.max(dpHold, -price);
    }

    return dpUnhold;
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
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[prices.length - 1][0];
  }

  public int maxProfitByDoublePoint(int[] prices) {
    int buy = 0;
    int sell = 0;
    int result = 0;
    while (sell < prices.length) {
      if (prices[sell] - prices[buy] < 0) {
        buy = sell;
      }
      result = Math.max(result, prices[sell] - prices[buy]);
      sell++;
    }
    return result;
  }

  public int maxProfitDBAndKadane(int[] prices) {
    int maxCur = 0;
    int result = 0;
    for (int i = 1; i < prices.length - 1; i++) {
      maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
      result = Math.max(result, maxCur);
    }
    return result;
  }

  public int maxProfit1(int[] prices) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        String key = prices[i] + "&" + prices[j];
        if (!map.containsKey(key)) {
          if (prices[j] > prices[i]) {
            map.put(key, prices[j] - prices[i]);
          }
        }
      }
    }
    System.out.println(map);
    int min = 0;
    for (String key : map.keySet()) {
      if (map.get(key) > min) {
        min = map.get(key);
      }
    }
    return min;
  }


  public static void main(String[] args) {
    BestTimeToBuyAndSellStock121 bestTimetoBuyandSellStock121 = new BestTimeToBuyAndSellStock121();
    System.out.println(bestTimetoBuyandSellStock121.maxProfitByDPWithArray(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(bestTimetoBuyandSellStock121.maxProfitByDPWithArray(new int[]{7, 6, 4, 3, 1}));
    System.out.println(bestTimetoBuyandSellStock121.maxProfitByDPWithArray(new int[]{2, 4, 1}));
    System.out.println(bestTimetoBuyandSellStock121.maxProfitByDPWithArray(new int[]{1, 2}));
  }

}

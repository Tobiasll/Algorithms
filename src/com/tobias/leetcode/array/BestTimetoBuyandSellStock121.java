package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock121 {

  public int maxProfit(int[] prices) {
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
    BestTimetoBuyandSellStock121 bestTimetoBuyandSellStock121 = new BestTimetoBuyandSellStock121();
    System.out.println(bestTimetoBuyandSellStock121.maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(bestTimetoBuyandSellStock121.maxProfit(new int[]{7,6,4,3,1}));
    System.out.println(bestTimetoBuyandSellStock121.maxProfit(new int[]{2,4,1}));
  }

}

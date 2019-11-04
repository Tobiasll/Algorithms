package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class S_62UniquePaths {

  public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp,1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[j] += dp[j - 1];
      }
    }
    return dp[n - 1];
  }


    public int uniquePathsByM(int m, int n) {
    int[] dp = new int[m];
    Arrays.fill(dp, 1);
    for (int i = n - 2; i >= 0; i--) {
      for (int j = m - 2; j >= 0; j--) {
        dp[j] = dp[j + 1] + dp[j];
      }
    }
    return dp[0];
  }


  public int uniquePathsByRecursive(int m, int n) {
    Map<String, Integer> memo = new HashMap<>();
    return uniquePaths(0, 0, m - 1, n - 1, memo);
  }

  private int uniquePaths(int x, int y, int m, int n, Map<String, Integer> memo) {

    if (x == m && y == n) {
      return 1;
    }

    int n1 = 0;
    int n2 = 0;
    String keyX = x + 1 + "@" + y;

    if (!memo.containsKey(keyX)) {
      if (x < m) {
        n1 = uniquePaths(x + 1, y, m, n, memo);
      }
    } else {
      n1 = memo.get(keyX);
    }

    String keyY = x + "@" + (y + 1);
    if (!memo.containsKey(keyY)) {
      if (y < n) {
        n2 = uniquePaths(x, y + 1, m, n, memo);
      }
    } else {
      n2 = memo.get(keyY);
    }
    memo.put(keyX, n1);
    memo.put(keyY, n2);
    return n1 + n2;
  }

  public static void main(String[] args) {
    S_62UniquePaths uniquePaths = new S_62UniquePaths();
    System.out.println(uniquePaths.uniquePaths(7, 3));
    System.out.println(uniquePaths.uniquePaths(3, 3));
  }
}

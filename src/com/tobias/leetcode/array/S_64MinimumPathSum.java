package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class S_64MinimumPathSum {

  public int minPathSum(int[][] grid) {
    Map<String, Integer> memo = new HashMap<>();
    return minPathSum(0, 0, grid.length - 1, grid[0].length - 1, memo, grid);
  }

  private int minPathSum(int x, int y, int m, int n, Map<String, Integer> memo, int[][] grid) {
    if (x == m && y == n) {
      return grid[x][y];
    }
    String keyX = x + 1 + "@" + y;
    // 因为n1和n2后面要进行最小值对比，所以这里需要将其设置为最大值
    int n1 = Integer.MAX_VALUE;
    int n2 = Integer.MAX_VALUE;
    if (memo.containsKey(keyX)) {
      n1 =  memo.get(keyX);
    } else {
      if (x + 1 <= m) {
        n1 = minPathSum(x + 1, y, m, n, memo, grid);
      }
    }

    String keyY = x + "@" + (y + 1);
    if (memo.containsKey(keyY)) {
      n2 = memo.get(keyY);
    } else {
      if (y + 1 <= n) {
        n2 = minPathSum(x, y + 1, m, n, memo, grid);
      }
    }
    String key = x + "@" + y;
    memo.put(key, Math.min(n1, n2) + grid[x][y]);
    return Math.min(n1, n2) + grid[x][y];
  }

  public static void main(String[] args) {
    S_64MinimumPathSum minimumPathSum = new S_64MinimumPathSum();
    System.out.println(minimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }
}

package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class S_63UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    int[] dp = new int[n];
    int i = 0;
    for (; i < dp.length; i++) {
      if (obstacleGrid[0][i] == 1) {
        dp[i] = 0;
        break;
      } else {
        dp[i] = 1;
      }
    }

    for (; i < dp.length; i++) {
      dp[i] = 0;
    }

    for (int x = 1; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (obstacleGrid[x][y] == 1) {
          dp[y] = 0;
        } else {
          if (y != 0) {
            dp[y] += dp[y - 1];
          }
        }
      }
    }

    return dp[n - 1];
  }


    public int uniquePathsWithObstaclesByRecursion(int[][] obstacleGrid) {
    Map<String, Integer> map = new HashMap<>();
    return uniquePathsWithObstacles(0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid, map);
  }

  private int uniquePathsWithObstacles(int x, int y, int m, int n, int[][] obstacleGrid, Map<String, Integer> map) {
    if (x <= m && y <= n && obstacleGrid[x][y] == 1) {
      return 0;
    }
    if (x == m && n == y) {
      return 1;
    }
    String keyX = x + 1 + "@" + y;
    int n1 = 0;
    int n2 = 0;
    if (map.containsKey(keyX)) {
      n1 =  map.get(keyX);
    } else {
      if (x <= m) {
        n1 = uniquePathsWithObstacles(x + 1, y, m, n, obstacleGrid, map);
      }
    }
    String keyY = x + "@" + (y + 1);
    if (map.containsKey(keyY)) {
      n2 = map.get(keyY);
    } else {
      if (y <= n) {
        n2 = uniquePathsWithObstacles(x, y + 1, m, n, obstacleGrid, map);
      }
    }
    map.put(keyX, n1);
    map.put(keyY, n2);
    return n1 + n2;
  }

  public static void main(String[] args) {
    S_63UniquePathsII uniquePathsII = new S_63UniquePathsII();
    System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{0,0,0}, {0, 1, 0}, {0,0,0}}));
    System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{1}}));
    System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{0, 1}}));
  }
}

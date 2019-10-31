package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 * adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [ {2}, {3,4}, {6,5,7}, {4,1,8,3} ] The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5
 * + 1 = 11).
 */
public class Triangle120 {

  public int minimumTotalByDPMatrixReversOrderArray(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int cols = triangle.get(rows - 1).size();
    int[] dp = new int[cols];
    for (int i = 0; i < cols; i++) {
      dp[i] = triangle.get(rows - 1).get(i);
    }
    for (int row = rows - 2; row >= 0; row--) {
      List<Integer> currentRow = triangle.get(row);
      for (int col = currentRow.size() - 1, index = dp.length - 1; col >= 0; col--, index--) {
        dp[index] = Math.min(dp[index], dp[index - 1]) + currentRow.get(col);
      }
    }

    return dp[cols - 1];
  }


  public int minimumTotalByDPMatrixOrderArray(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int cols = triangle.get(rows - 1).size();
    int[] dp = new int[cols];
    dp[0] = triangle.get(0).get(0);
    for (int row = 1; row < rows; row++) {
      List<Integer> currentRow = triangle.get(row);
      int col = currentRow.size() - 1;
      dp[col] = dp[col - 1] + currentRow.get(col);
      col--;
      while (col > 0) {
        dp[col] = Math.min(dp[col], dp[col - 1]) + currentRow.get(col);
        col--;
      }
      dp[col] = dp[col] + currentRow.get(col);
    }

    int min = Integer.MAX_VALUE;
    for (int col = 0; col < cols; col++) {
      min = Math.min(min, dp[col]);
    }
    return min;
  }


  public int minimumTotalByDPMatrixReverseOrder(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int cols = triangle.get(rows - 1).size();
    int[][] dp = new int[rows][cols];
    for (int i = 0; i < cols; i++) {
      dp[rows - 1][i] = triangle.get(rows - 1).get(i);
    }
    for (int row = rows - 2; row >= 0; row--) {
      List<Integer> currentRow = triangle.get(row);
      for (int col = 0; col < currentRow.size(); col++) {
        dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + currentRow.get(col);
      }
    }
    return dp[0][0];
  }


  public int minimumTotalByDPMatrixOrder(List<List<Integer>> triangle) {
    int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
    dp[0][0] = triangle.get(0).get(0);
    for (int row = 1; row < triangle.size(); row++) {
      List<Integer> currentRow = triangle.get(row);
      int col = 0;
      dp[row][col] = dp[row - 1][col] + currentRow.get(col);
      col++;
      while (col < currentRow.size() - 1) {
        dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + currentRow.get(col);
        col++;
      }
      dp[row][col] = dp[row - 1][col - 1] + currentRow.get(col);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
      min = Math.min(min, dp[triangle.size() - 1][i]);
    }
    return min;
  }


  public int minimumTotalByDAR(List<List<Integer>> triangle) {
    Map<String, Integer> map = new HashMap<>();
    return minimumTotalByDAR(triangle, 0, 0, map);
  }


  private int minimumTotalByDAR(List<List<Integer>> triangle, int row, int col,
      Map<String, Integer> map) {
    if (row == triangle.size()) {
      return 0;
    }
    String key = row + "&" + col;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    int min = Integer.MAX_VALUE;
    List<Integer> currentRow = triangle.get(row);
    min = Math.min(min, currentRow.get(col) + minimumTotalByDAR(triangle, row + 1, col, map));

    if (col + 1 < currentRow.size()) {
      min = Math
          .min(min, currentRow.get(col + 1) + minimumTotalByDAR(triangle, row + 1, col + 1, map));
    }
    map.put(key, min);
    return min;
  }


  public static void main(String[] args) {
    Triangle120 triangle120 = new Triangle120();
    List<List<Integer>> triangle = new ArrayList<>();
//    [[-1],[2,3],[1,-1,-3]]
    triangle.add(Collections.singletonList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(triangle120.minimumTotalByDPMatrixReversOrderArray(triangle));
  }
}

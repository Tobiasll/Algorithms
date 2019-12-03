package com.tobias.leetcode.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class S_52NQueensII {

  private int count = 0;

  public int totalNQueens(int n) {
    backtrack(new ArrayList<>(), n);
    return count;
  }

  private void backtrack(List<Integer> curQueueOfCol, int n) {
    if (curQueueOfCol.size() == n) {
      count++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (!curQueueOfCol.contains(i)) {
        if (isInDiagonal(curQueueOfCol, i)) {
          continue;
        }
        curQueueOfCol.add(i);
        backtrack(curQueueOfCol, n);
        curQueueOfCol.remove(curQueueOfCol.size() - 1);
      }
    }
  }

  private boolean isInDiagonal(List<Integer> curQueueOfCol, int col) {
    for (int row = 0; row < curQueueOfCol.size(); row++) {
      if (Math.abs(curQueueOfCol.size() - row) == Math.abs(col - curQueueOfCol.get(row))) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    S_52NQueensII nQueensII = new S_52NQueensII();
    System.out.println(nQueensII.totalNQueens(4));
  }
}

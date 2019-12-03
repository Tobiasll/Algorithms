package com.tobias.leetcode.backtrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class S_51NQueens {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), n);
    return result;
  }

  private void backtrack(List<List<String>> result, List<Integer> curQueueOfCol, int n) {
    if (curQueueOfCol.size() == n) {
      List<String> temp = new ArrayList<>();
      for (Integer colIndex : curQueueOfCol) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[colIndex] = 'Q';
        temp.add(new String(chars));
      }
      result.add(temp);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!curQueueOfCol.contains(i)) {
        if (isInDiagonal(curQueueOfCol, i)) {
          continue;
        }
        curQueueOfCol.add(i);
        backtrack(result, curQueueOfCol, n);
        curQueueOfCol.remove(curQueueOfCol.size() - 1);
      }
    }


  }

  private boolean isInDiagonal(List<Integer> curQueueOfCol, int col) {
    int curRow = curQueueOfCol.size();
    for (int row = 0; row < curRow; row++) {
      if (Math.abs(curRow - row) == Math.abs(col - curQueueOfCol.get(row))) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    S_51NQueens nQueens = new S_51NQueens();
    List<List<String>> queens = nQueens.solveNQueens(4);
    for (List<String> queen : queens) {
      for (String s : queen) {
        System.out.println(s);
      }
    }
  }
}

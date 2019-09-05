package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 */
public class SudokuSolver37 {


  public void solveSudoku(char[][] board) {
    solve(board);
  }

  private boolean solve(char[][] board) {
    // 遍历行
    for (int i = 0; i < board.length; i++) {
      // 遍历列
      for (int j = 0; j < board.length; j++) {
        // 看此时位置的内容是否是'.'，是的话则说明需要填写，否则就已经是数字了，没必要填写
        if (board[i][j] == '.') {
          // 默认填一个1
          char num = '1';
          // 不断的递增数字，当填写不成立回溯填写下一个数字
          while (num <= '9') {
            // 验证此时填写的数字是否符合要求
            if (isValid(i, j, board, num)) {
              // 验证成功，将当前数字填写进去
              board[i][j] = num;
              // 查看填写完是否符合要求，是否解决掉当前的问题
              if (solve(board)) {
                // 解决成功
                 return true;
              } else {
                // 进行回溯
                // 解决失败，将刚刚填写进去的数字去除，递增数字，尝试将新数字填写进去，看看能不能解决问题，不能则继续递增
                board[i][j] = '.';
              }
            }
            // 递增数字
            num++;
          }
          // 已经将所有可能性都填写进去了，同时无法解决问题，直接方法失败false
          return false;
        }
      }
    }
    // 回溯法填写数独成功
    return true;
  }

  private boolean isValid(int row, int col, char[][] board, char c) {
    // 验证每一行
    for (char[] chars : board) {
      if (chars[col] == c) {
        return false;
      }
    }
    // 验证每一列
    for (int i = 0; i < board.length; i++) {
      if (board[row][i] == c) {
        return false;
      }
    }

    // 拿到子列表的开始行
    int rowStart = row / 3 * 3;
    // 拿到子列表的开始列
    int colStart = col / 3 * 3;
    // 验证子列表
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[rowStart + i][colStart + j] == c) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {

    char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'}
    ,{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

    SudokuSolver37 sudokuSolver37 = new SudokuSolver37();
    sudokuSolver37.solveSudoku(board);
    for (char[] chars : board) {
      System.out.println(Arrays.toString(chars));
    }

  }
}

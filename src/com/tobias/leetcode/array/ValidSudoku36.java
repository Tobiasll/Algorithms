package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to
 * the following rules:
 *
 * Each row must contain the digits 1-9 without repetition. Each column must contain the digits 1-9
 * without repetition. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input: [ ["5","3",".",".","7",".",".",".","."], ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."], ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"], ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."], [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"] ] Output: true Example 2:
 *
 * Input: [ ["8","3",".",".","7",".",".",".","."], ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."], ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"], ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."], [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"] ] Output: false Explanation: S ame as Example 1, except
 * with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left
 * 3x3 sub-box, it is invalid. Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable. Only the filled
 * cells need to be validated according to the mentioned rules. The given board contain only digits
 * 1-9 and the character '.'. The given board size is always 9x9.
 */
public class ValidSudoku36 {

  public boolean isValidSudoku(char[][] board) {
    int[] vset = new int[9];
    int[] hset = new int[9];
    int[] bckt = new int[9];
    int idx = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          idx = 1 << (board[i][j] - '0');
          if ((hset[i] & idx) > 0 ||
              (vset[j] & idx) > 0 ||
              (bckt[(i / 3) * 3 + j / 3] & idx) > 0) {
            return false;
          }
          hset[i] |= idx;
          vset[j] |= idx;
          bckt[(i / 3) * 3 + j / 3] |= idx;
        }
      }
    }
    return true;
  }


  public boolean bestResolveIsValidSudoku(char[][] board) {
    Set<Object> seen = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != '.') {
          String str = "(" + board[i][j] + ")";
          if (!seen.add(i + str) || !seen.add(str + j) || !seen.add(i / 3 + str + j / 3)) {
            return false;
          }
        }
      }
    }

    return true;
  }


  public boolean isValidSudokuByViolence(char[][] board) {
    for (char[] rows : board) {
      if (!isValidRow(rows)) {
        return false;
      }
    }
    for (int i = 0; i < board.length; i++) {
      if (!isValidCol(i, board)) {
        return false;
      }
    }

    for (int i = 0; i < board.length; i += 3) {
      for (int j = 0; j < board[i].length; j += 3) {
        if (!isValidSubTable(i, j, board)) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isValidSubTable(int row, int col, char[][] board) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        char c = board[row + i][col + j];
        if (c != '.') {
          if (map.getOrDefault(c, 0) != 0) {
            return false;
          } else {
            map.put(c, 1);
          }
        }
      }
    }
    return true;
  }


  private boolean isValidCol(int col, char[][] board) {
    Map<Character, Integer> map = new HashMap<>();
    for (char[] chars : board) {
      if (chars[col] != '.') {
        if (map.getOrDefault(chars[col], 0) != 0) {
          return false;
        } else {
          map.put(chars[col], 1);
        }
      }
    }
    return true;
  }


  private boolean isValidRow(char[] boardRow) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : boardRow) {
      if (c != '.') {
        if (map.getOrDefault(c, 0) != 0) {
          return false;
        } else {
          map.put(c, 1);
        }
      }
    }
    return true;
  }


  public static void main(String[] args) {
    ValidSudoku36 validSudoku36 = new ValidSudoku36();
    char[][] temp = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };

//    System.out.println(validSudoku36.isValidSudoku(temp));
    String result = "";
    System.out.println(Integer.toBinaryString(-2));
    System.out.println(-2 % 2);
    System.out.println(-2 / 2);
    System.out.println(-1 % 2);
    System.out.println(-1 / 2);
    System.out.println(-1 % 2);
    System.out.println(-1 / 2);
    int n = -5;
    int count = 0;
    int time = 0;
    while (n != 0 && time < 31) {
      count += n % 2;
      n = n / 2;
      time++;
    }
    System.out.println(count);
    System.out.println(time);
  }


}

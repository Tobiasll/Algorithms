package com.tobias.leetcode.backtrack;


/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   {'A','B','C','E'},
 *   {'S','F','C','S'},
 *   {'A','D','E','E'}
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class S_79WordSearch {

  public boolean exist(char[][] board, String word) {

    if (board.length == 0) {
      return false;
    }
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (exist(board, word, row, col, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean exist(char[][] board, String word, int row, int col, int index) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return false;
    }
    if (board[row][col] >= 194 || board[row][col] != word.charAt(index)) {
      return false;
    }
    if (index == word.length() - 1) {
      return true;
    }

    board[row][col] ^= 128;
    boolean up = exist(board, word, row - 1, col, index + 1);
    if (up) {
      return true;
    }
    boolean down = exist(board, word, row + 1, col, index + 1);
    if (down) {
      return true;
    }
    boolean left = exist(board, word, row, col - 1, index + 1);
    if (left) {
      return true;
    }
    boolean right = exist(board, word, row, col + 1, index + 1);
    if (right) {
      return true;
    }
    board[row][col] ^= 128;
    return false;
  }

  public static void main(String[] args) {
    S_79WordSearch wordSearch = new S_79WordSearch();
//    System.out.println(wordSearch.exist(new char[][]{
//        {'A','B','C','E'},
//        {'S','F','C','S'},
//        {'A','D','E','E'}}, "ABCCED"));

    System.out.println(wordSearch.exist(new char[][]{
        {'C','A','A'},
        {'A','A','A'},
        {'B','C','D'}}, "AAB"));

    System.out.println((int) ( 'B' ^ 128));
  }
}

package com.tobias.leetcode.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   {'o','a','a','n'},
 *   {'e','t','a','e'},
 *   {'i','h','k','r'},
 *   {'i','f','l','v'}
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
public class S_212WordSearchII {

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board.length == 0) {
      return result;
    }
    for (String word : words) {
      boolean isFound = false;
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (findWords(board, word, row, col, 0)) {
            result.add(word);
            isFound = true;
            break;
          }
        }
        if (isFound) {
          break;
        }
      }
    }

    return result;
  }

  private boolean findWords(char[][] board, String word, int row, int col, int index) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ) {
      return false;
    }
    if (board[row][col] >= 200 || word.charAt(index) != board[row][col]) {
      return false;
    }
    if (word.length() - 1 == index) {
      return true;
    }
    board[row][col] ^= 128;
    if (findWords(board, word, row - 1, col, index + 1)) {
      board[row][col] ^= 128;
      return true;
    }
    if (findWords(board, word, row + 1, col, index + 1)) {
      board[row][col] ^= 128;
      return true;
    }
    if (findWords(board, word, row, col - 1, index + 1)) {
      board[row][col] ^= 128;
      return true;
    }
    if (findWords(board, word, row, col + 1, index + 1)) {
      board[row][col] ^= 128;
      return true;
    }
    board[row][col] ^= 128;
    return false;
  }

  public static void main(String[] args) {
    System.out.println((int) 'z');
    S_212WordSearchII wordSearchII = new S_212WordSearchII();
    System.out.println(wordSearchII.findWords(new char[][]{
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}
    }, new String[]{"oath","pea","eat","rain"}));
  }
}

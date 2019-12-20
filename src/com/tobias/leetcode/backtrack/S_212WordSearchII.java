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
    TreeNode treeNode = buildTreeNodeByWords(words);
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        dfs(board, row, col, treeNode, result);
      }
    }
    return result;
  }

  private void dfs(char[][] board, int row, int col, TreeNode root, List<String> result) {
    char c = board[row][col];
    if (c == '#' || root.next[c - 'a'] == null) {
      return;
    }
    root = root.next[c - 'a'];
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    board[row][col] = '#';
    if (row > 0) {
      dfs(board, row - 1, col, root, result);
    }
    if (col > 0) {
      dfs(board, row, col - 1, root, result);
    }
    if (row < board.length - 1) {
      dfs(board, row + 1, col, root, result);
    }
    if (col < board[0].length - 1) {
      dfs(board, row, col + 1, root, result);
    }

    board[row][col] = c;
  }


  private TreeNode buildTreeNodeByWords(String[] words) {
    TreeNode root = new TreeNode();
    for (String word : words) {
      TreeNode node = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (node.next[i] == null) {
          node.next[i] = new TreeNode();
        }
        node = node.next[i];
      }
      node.word = word;
    }
    return root;
  }

  class TreeNode {
    TreeNode[] next = new TreeNode[26];
    String word;
  }

  public List<String> findWordsByBacktrack(char[][] board, String[] words) {
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

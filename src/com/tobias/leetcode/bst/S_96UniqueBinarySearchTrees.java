package com.tobias.leetcode.bst;


/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class S_96UniqueBinarySearchTrees {

  public int numTrees(int n) {
    return numTrees(1, n);
  }

  private int numTrees(int start, int end) {
    int result = 0;
    if (start > end) {
      return 1;
    }
    if (start == end) {
      return 1;
    }
    for (int i = start; i <= end; i++) {
      int leftTrees = numTrees(start, i - 1);
      int rightTrees = numTrees(i + 1, end);
      result += leftTrees * rightTrees;
    }
    return result;
  }

  public static void main(String[] args) {
    S_96UniqueBinarySearchTrees uniqueBinarySearchTrees = new S_96UniqueBinarySearchTrees();
    int i = uniqueBinarySearchTrees.numTrees(3);
    System.out.println(i);
  }

}

package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */
public class S_230KthSmallestElementInBST {

  private int count = 0;
  private int result = 0;

  public int kthSmallestByRecursive(TreeNode root, int k) {
    if (root != null) {
      kthSmallest(root.left, k);
      if (count < k) {
        result = root.val;
        count++;
      } else if (count == k) {
        return result;
      }

      kthSmallest(root.right, k);
    }
    return result;
  }

  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();

    return result;
  }

  public static void main(String[] args) {
    S_230KthSmallestElementInBST kthSmallestElementInBST = new S_230KthSmallestElementInBST();
    BinaryTree binaryTree = new BinaryTree(new int[]{5,3,6,2,4,1});
    System.out.println(binaryTree);
    System.out.println(kthSmallestElementInBST.kthSmallest(binaryTree.getRoot(), 3));
  }


}

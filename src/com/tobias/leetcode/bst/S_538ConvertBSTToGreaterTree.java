package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class S_538ConvertBSTToGreaterTree {

  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root != null) {
      convertBST(root.right);
      root.val += sum;
      sum = root.val;
      convertBST(root.left);
      return root;
    }
    return null;
  }

  public static void main(String[] args) {
    S_538ConvertBSTToGreaterTree convertBSTToGreaterTree = new S_538ConvertBSTToGreaterTree();
    BinaryTree binaryTree = new BinaryTree(new int[]{5, 2, 13});
    System.out.println(binaryTree);
    convertBSTToGreaterTree.convertBST(binaryTree.getRoot());
    System.out.println(binaryTree);
  }
}

package com.tobias.leetcode.binary_search;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class S_104MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{3,9,20});
    TreeNode root = binaryTree.getRoot();
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    S_104MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new S_104MaximumDepthOfBinaryTree();
    System.out.println(maximumDepthOfBinaryTree.maxDepth(root));
    binaryTree.setRoot(root);
    System.out.println(binaryTree);
  }

}

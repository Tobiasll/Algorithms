package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class S_543DiameterOfBinaryTree {

  private int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return max - 1;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    max = Math.max(max, left + right + 1);
    return Math.max(left + 1, right + 1);
  }


  public static void main(String[] args) {
    S_543DiameterOfBinaryTree diameterOfBinaryTree = new S_543DiameterOfBinaryTree();
    BinaryTree binaryTree = new BinaryTree(new int[]{1, 3});
    binaryTree.getRoot().left = new TreeNode(2);
    binaryTree.getRoot().left.left = new TreeNode(4);
    binaryTree.getRoot().left.right = new TreeNode(5);
    System.out.println(binaryTree);

    System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(binaryTree.getRoot()));
  }
}

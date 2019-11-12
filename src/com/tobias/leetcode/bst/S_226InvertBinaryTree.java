package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.LinkedList;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *
 *         4
 *       /   \
 *      2     7
 *    / \   / \
 *   1   3 6   9
 *   Output:
 *
 *         4
 *      /   \
 *    7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia: This problem was inspired by this original tweet by
 * Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary
 * tree on a whiteboard so f*** off.
 */
public class S_226InvertBinaryTree {


  public TreeNode invertTree(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      TreeNode pollNode = queue.pollFirst();
      TreeNode temp = pollNode.left;
      pollNode.left = pollNode.right;
      pollNode.right = temp;
      BinaryTree.addLeftAndRightNodeToQueue(queue, pollNode);
    }
    return root;
  }

  public TreeNode invertTreeByRecursive(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }


  public static void main(String[] args) {
    S_226InvertBinaryTree invertBinaryTree = new S_226InvertBinaryTree();
    BinaryTree binaryTree = new BinaryTree(new int[]{4, 2, 7, 1, 3, 6, 9});
    TreeNode treeNode = invertBinaryTree.invertTree(binaryTree.getRoot());
    binaryTree.setRoot(treeNode);
    System.out.println(binaryTree);

  }
}

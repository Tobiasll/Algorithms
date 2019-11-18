package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 */
public class S_110BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    return getMaxDeep2(root) != -1;
  }

  private int getMaxDeep2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftNum = getMaxDeep2(root.left);
    if (leftNum == -1) {
      return -1;
    }
    int rightNum = getMaxDeep2(root.right);
    if (rightNum == -1) {
      return -1;
    }
    if (Math.abs(leftNum - rightNum) > 1) {
      return -1;
    }
    return Math.max(leftNum, rightNum) + 1;
  }


  public boolean isBalanced1(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(getMaxDeep1(root.left) - getMaxDeep1(root.right)) > 1) {
      return false;
    }

    return isBalanced1(root.left) && isBalanced1(root.right);
  }

  private int getMaxDeep1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getMaxDeep1(root.left), getMaxDeep1(root.right)) + 1;
  }






  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{3, 20});
    binaryTree.getRoot().left = new TreeNode(9);
    binaryTree.getRoot().right.left = new TreeNode(15);
    binaryTree.getRoot().right.right = new TreeNode(7);
    System.out.println(binaryTree);
    S_110BalancedBinaryTree balancedBinaryTree = new S_110BalancedBinaryTree();
    System.out.println(balancedBinaryTree.isBalanced(binaryTree.getRoot()));
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(2);
    treeNode.left.left = new TreeNode(3);
    treeNode.left.right = new TreeNode(3);
    treeNode.right.left = new TreeNode(3);
    treeNode.right.right = new TreeNode(3);
    treeNode.left.left.left = new TreeNode(4);
    treeNode.left.left.right = new TreeNode(4);
    treeNode.left.right.left = new TreeNode(4);
    treeNode.left.right.right = new TreeNode(4);
    treeNode.right.left.left = new TreeNode(4);
    treeNode.right.left.right = new TreeNode(4);
    treeNode.left.left.left.left = new TreeNode(5);
    treeNode.left.left.left.right = new TreeNode(5);
    binaryTree.setRoot(treeNode);
    System.out.println(binaryTree);
    System.out.println(balancedBinaryTree.isBalanced(binaryTree.getRoot()));

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    binaryTree.setRoot(root);
    System.out.println(binaryTree);
    System.out.println(balancedBinaryTree.isBalanced(binaryTree.getRoot()));

  }
}

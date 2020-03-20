package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 *Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class S_617MergeTwoBinaryTrees {

  private TreeNode treeNode = null;

  public static void main(String[] args) {
    BinaryTree binaryTreeOne = new BinaryTree(new int[]{1, 2});
    binaryTreeOne.getRoot().left = new TreeNode(3);
    binaryTreeOne.getRoot().left.left = new TreeNode(5);
    BinaryTree binaryTreeTwo = new BinaryTree(new int[]{2, 3});
    binaryTreeTwo.getRoot().left = new TreeNode(1);
    binaryTreeTwo.getRoot().left.right = new TreeNode(4);
    binaryTreeTwo.getRoot().right.right = new TreeNode(7);

    System.out.println(binaryTreeOne);
    System.out.println(binaryTreeTwo);
    S_617MergeTwoBinaryTrees mergeTwoBinaryTrees = new S_617MergeTwoBinaryTrees();
    mergeTwoBinaryTrees.treeNode = binaryTreeOne.getRoot();
    TreeNode treeNode = mergeTwoBinaryTrees.mergeTrees(binaryTreeOne.getRoot(), binaryTreeTwo.getRoot());
    System.out.println(new BinaryTree(treeNode));

  }

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    t1.val += t2.val;
    mergeTreesHelper(t1, t2);
    return t1;
  }

  private void mergeTreesHelper(TreeNode t1, TreeNode t2) {
    if (t2 == null) {
      return;
    }
    if (t1.left == null && t2.left!= null) {
      t1.left = new TreeNode(t2.left.val);
    } else if (t2.left != null){
      t1.left.val += t2.left.val;
    }
    if (t1.right == null && t2.right != null) {
      t1.right = new TreeNode(t2.right.val);
    } else if (t2.right != null){
      t1.right.val += t2.right.val;
    }

    mergeTreesHelper(t1.left, t2.left);
    mergeTreesHelper(t1.right, t2.right);

  }
}

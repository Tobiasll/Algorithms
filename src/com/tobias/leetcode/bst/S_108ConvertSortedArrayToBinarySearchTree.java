package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;


/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class S_108ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    int haft = nums.length / 2;
    TreeNode root = null;
    if (nums.length % 2 != 0) {
      root = addTreeNode(null, nums[haft]);
    }
    for (int l = haft - 1, r = nums.length - 1; l >= 0 && r >= haft - 1; l--, r--) {
      if (r > 0) {
        root = addTreeNode(root, nums[r]);
      }
      if (l >= 0) {
        root = addTreeNode(root, nums[l]);
      }
    }
    return root;
  }

  private TreeNode addTreeNode(TreeNode root, int num) {
    if (root == null) {
      return new TreeNode(num);
    }
    if (root.val > num) {
      root.left = addTreeNode(root.left, num);
    } else {
      root.right = addTreeNode(root.right, num);
    }

    return root;
  }

  public static void main(String[] args) {
    S_108ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new S_108ConvertSortedArrayToBinarySearchTree();
    System.out.println(new BinaryTree(convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-10,-3,0,5,9})));
    System.out.println(new BinaryTree(convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{1,3})));
  }

}

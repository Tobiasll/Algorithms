package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class S_437PathSumIII {

  private int count = 0;

  public int pathSum(TreeNode root, int sum) {
    pathSumHelper(root, sum);
    pathSumHelper(root.left, sum);
    pathSumHelper(root.right, sum);
    return count;
  }

  private void pathSumHelper(TreeNode root, int sum) {
    if (sum < 0) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (sum == root.val) {
        count++;
      }
      return;
    }
    if (root.left == null) {
      pathSumHelper(root.right, sum - root.val);
      return;
    }
    if (root.right == null) {
      pathSumHelper(root.left, sum - root.val);
      return;
    }
    pathSumHelper(root.left, sum - root.val);
    pathSumHelper(root.right, sum - root.val);
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{10, 5, 3});
    binaryTree.getRoot().right = new TreeNode(-3);
    binaryTree.getRoot().right.right = new TreeNode(11);
    binaryTree.getRoot().left.right = new TreeNode(2);
    binaryTree.getRoot().left.left.left = new TreeNode(3);
    binaryTree.getRoot().left.right.right = new TreeNode(1);
    binaryTree.getRoot().left.left.right = new TreeNode(-2);
    System.out.println(binaryTree);
    S_437PathSumIII pathSumIII = new S_437PathSumIII();
    System.out.println(pathSumIII.pathSum(binaryTree.getRoot(),8));
  }
}

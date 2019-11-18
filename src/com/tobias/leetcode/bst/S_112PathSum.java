package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 */
public class S_112PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    return hasPathSumHelper(root, sum);
  }

  private boolean hasPathSumHelper(TreeNode root, int sum) {
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    if (root.left == null) {
      return hasPathSumHelper(root.right, sum - root.val);
    }
    if (root.right == null) {
      return hasPathSumHelper(root.left, sum - root.val);
    }
    return hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val);
  }


  public boolean hasPathSumByBFS(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> queueNum = new LinkedList<>();
    queue.offer(root);
    queueNum.offer(root.val);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode pollNode = queue.poll();
        Integer lastValue = queueNum.poll();
        if (pollNode.left == null && pollNode.right == null && lastValue == sum) {
          return true;
        }
        if (pollNode.left != null ) {
          queue.offer(pollNode.left);
          queueNum.offer(pollNode.left.val + lastValue);
        }
        if (pollNode.right != null) {
          queue.offer(pollNode.right);
          queueNum.offer(pollNode.right.val + lastValue);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{5,4,8});
    binaryTree.getRoot().left.left = new TreeNode(11);
    binaryTree.getRoot().right.left = new TreeNode(13);
    binaryTree.getRoot().right.right = new TreeNode(4);
    binaryTree.getRoot().left.left.left = new TreeNode(7);
    binaryTree.getRoot().left.left.right = new TreeNode(2);
    binaryTree.getRoot().right.right.right = new TreeNode(1);
    System.out.println(binaryTree);
    S_112PathSum pathSum = new S_112PathSum();
    System.out.println(pathSum.hasPathSum(binaryTree.getRoot(), 22));

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(3);
    binaryTree.setRoot(root);
    System.out.println(binaryTree);
    System.out.println(pathSum.hasPathSum(root, 1));
  }

}

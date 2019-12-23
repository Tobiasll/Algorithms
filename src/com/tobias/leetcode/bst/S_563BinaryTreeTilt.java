package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 *
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */
public class S_563BinaryTreeTilt {

  private int result;

  public int findTil(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int result = 0;
    Stack<TreeNode> stack = new Stack<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode peek = stack.peek();
      if ((peek.left == null || map.containsKey(peek.left)) && (peek.right == null || map.containsKey(peek.right))) {
        TreeNode pop = stack.pop();
        int left = map.getOrDefault(pop.left, 0);
        int right = map.getOrDefault(pop.right, 0);
        result += Math.abs(left - right);
        map.put(pop, left + right + pop.val);
      } else {
        if (peek.left != null && !map.containsKey(peek.left)) {
          stack.push(peek.left);
        }
        if (peek.right != null && !map.containsKey(peek.right)) {
          stack.push(peek.right);
        }
      }

    }

    return result;
  }


  public int findTilByRecursive(TreeNode root) {
    findTiltHelper(root);
    return result;
  }

  public int findTiltHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = findTiltHelper(root.left);
    int right = findTiltHelper(root.right);
    System.out.println(root.val + " = |" + left + " - " + right + "|");
    result += Math.abs(left - right);

    return left + right + root.val;
  }


    /**
     * 题目理解有误，不能从上往下遍历，应该从下往上遍历
     * 遇到[1,2,3,4,null,5] 会出错
     *    1
     *  2 ' 3
     * 4'n 5'n
     *
     * 4 = |0 - 0|
     * 2 = |4 - 0|
     * 5 = |0 - 0|
     * 3 = |5 - 0|
     * 1 = |6 - 8|
     */
  public int findTiltByLevel(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int result = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode poll = queue.poll();
        result += Math.abs((poll.left != null ? poll.left.val : 0) -  (poll.right != null ? poll.right.val : 0));
        if (poll.left != null) {
          queue.offer(poll.left);
        }
        if (poll.right != null) {
          queue.offer(poll.right);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{1, 3});
    binaryTree.getRoot().left = new TreeNode(2);
    binaryTree.getRoot().left.left = new TreeNode(4);
    binaryTree.getRoot().right.left = new TreeNode(5);
    System.out.println(binaryTree);
    S_563BinaryTreeTilt binaryTreeTilt = new S_563BinaryTreeTilt();
    System.out.println(binaryTreeTilt.findTil(binaryTree.getRoot()));
  }
}

package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class S_257BinaryTreePaths {

  public List<String> binaryTreePathsByBFS(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    Queue<String> queueStr = new LinkedList<>();
    queueStr.offer(root.val + "->");
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode pollNode = queue.poll();
        String pollStr = queueStr.poll();
        if (pollNode.left == null && pollNode.right == null) {
          result.add(pollStr.substring(0, pollStr.length() - 2));
        }
        if (pollNode.left != null) {
          queue.offer(pollNode.left);
          queueStr.offer(pollStr + pollNode.left.val + "->");
        }
        if (pollNode.right != null) {
          queue.offer(pollNode.right);
          queueStr.offer(pollStr + pollNode.right.val + "->");
        }
      }
    }

    return result;
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    while (root != null || !stack.isEmpty()) {

    }

    return result;
  }

    public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{1,3});
    binaryTree.getRoot().left = new TreeNode(2);
    binaryTree.getRoot().left.right = new TreeNode(5);
    System.out.println(binaryTree);
    S_257BinaryTreePaths binaryTreePaths = new S_257BinaryTreePaths();
    System.out.println(binaryTreePaths.binaryTreePaths(binaryTree.getRoot()));
  }
}

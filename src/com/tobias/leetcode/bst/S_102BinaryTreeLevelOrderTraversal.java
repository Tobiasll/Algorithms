package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class S_102BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> insideList = new ArrayList<>(queue.size());
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode pollNode = queue.poll();
        insideList.add(pollNode.val);
        if (pollNode.left != null) {
          queue.offer(pollNode.left);
        }
        if (pollNode.right != null) {
          queue.offer(pollNode.right);
        }
      }
      result.add(insideList);
    }
    return result;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{3, 20, 15});
    binaryTree.getRoot().left = new TreeNode(9);
    binaryTree.getRoot().right.right = new TreeNode(7);
    System.out.println(binaryTree);
    S_102BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new S_102BinaryTreeLevelOrderTraversal();
    List<List<Integer>> list = binaryTreeLevelOrderTraversal.levelOrder(binaryTree.getRoot());
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }

  }

}

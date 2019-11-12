package com.tobias.leetcode.binary_search;

import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class S_107BinaryTreeLevelOrderTraversalII {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return result;
    }
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> insideList = new ArrayList<>();
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode pollNode = queue.poll();
        insideList.add(pollNode.val);
        BinaryTree.offerLeftAndRightNodeToQueue(queue, pollNode);
      }
      result.add(insideList);
    }
    Collections.reverse(result);
    return result;
  }

  public static void main(String[] args) {

  }

}

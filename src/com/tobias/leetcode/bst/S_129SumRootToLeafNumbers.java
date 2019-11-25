package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class S_129SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    int sum = 0;
    if (root == null) {
      return sum;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> queueStr = new LinkedList<>();
    queueStr.offer(root.val);
    queue.offer(root);
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode poll = queue.poll();
        Integer value = queueStr.poll();
        if (poll.left == null && poll.right == null) {
          sum += value;
        }
        if (poll.left != null) {
          queueStr.offer((value * 10) + poll.left.val);
          queue.offer(poll.left);
        }
        if (poll.right != null) {
          queueStr.offer((value * 10) + poll.right.val);
          queue.offer(poll.right);
        }
      }
    }

    return sum;
  }


  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{1, 3});
    binaryTree.getRoot().left = new TreeNode(2);
    System.out.println(binaryTree);
    S_129SumRootToLeafNumbers sumRootToLeafNumbers = new S_129SumRootToLeafNumbers();
    System.out.println(sumRootToLeafNumbers.sumNumbers(binaryTree.getRoot()));
  }
}

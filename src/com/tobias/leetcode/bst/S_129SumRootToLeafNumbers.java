package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

  private int sum = 0;

  public int sumNumbersByBFS(TreeNode root) {
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


  public int sumNumbers(TreeNode root) {
    int sum = 0;
    if (root == null) {
      return sum;
    }
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> valStack = new Stack<>();
    TreeNode last = null;

    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        valStack.push(root.val);
        root = root.left;
      } else {
        TreeNode peek = stack.peek();
        if (peek.left == null && peek.right == null) {
          int factor = 1;
          for (int i = valStack.size() - 1; i >= 0; i--) {
            sum += valStack.get(i) * factor;
            factor *= 10;
          }
        }
        if (peek.right != null && peek.right != last) {
          root = peek.right;
        } else {
          valStack.pop();
          last = stack.pop();
        }
      }
    }
    return sum;
  }

    public int sumNumbersByBacktrack(TreeNode root) {
    if (root != null) {
      sumNumbers(root, new ArrayList<>());
    }
    return sum;
  }

  private void sumNumbers(TreeNode root, List<Integer> tempList) {
    if (root.left == null && root.right == null) {
      int factor = 10;
      for (int i = tempList.size() - 1; i >= 0; i--) {
        sum += tempList.get(i) * factor;
        factor *= 10;
      }
      sum += root.val;
      return;
    }

    if (root.left == null) {
      tempList.add(root.val);
      sumNumbers(root.right, tempList);
      tempList.remove(tempList.size() - 1);
      return;
    }
    if (root.right == null) {
      tempList.add(root.val);
      sumNumbers(root.right, tempList);
      tempList.remove(tempList.size() - 1);
      return;
    }

    tempList.add(root.val);
    sumNumbers(root.left, tempList);
    tempList.remove(tempList.size() - 1);

    tempList.add(root.val);
    sumNumbers(root.right, tempList);
    tempList.remove(tempList.size() - 1);

  }

    public int sumNumbersByRecursive(TreeNode root) {
    if (root != null) {
      sumNumbers(root, 0);
    }
    return sum;
  }

  private void sumNumbers(TreeNode root, int value) {

    if (root.left == null && root.right == null) {
      sum += value * 10 + root.val;
    }
    value = value == 0 ? 0 : (value * 10);
    if (root.left != null) {
      sumNumbers(root.left,  value + root.val);
    }

    if (root.right != null) {
      sumNumbers(root.right, value + root.val);
    }
  }


  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{4});
    binaryTree.getRoot().left = new TreeNode(9);
    binaryTree.getRoot().right = new TreeNode(0);
    binaryTree.getRoot().left.left = new TreeNode(5);
    binaryTree.getRoot().left.right = new TreeNode(1);
    System.out.println(binaryTree);
    S_129SumRootToLeafNumbers sumRootToLeafNumbers = new S_129SumRootToLeafNumbers();
    System.out.println(sumRootToLeafNumbers.sumNumbers(binaryTree.getRoot()));
  }
}

package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class S_98ValidateBinarySearchTree {


  /**
   * Runtime: 1 ms, faster than 48.85% of Java online submissions for Validate Binary Search Tree.
   * Memory Usage: 38.8 MB, less than 82.33% of Java online submissions for Validate Binary Search Tree
   */
  public boolean isValidBSTByMorris(TreeNode root) {

    TreeNode last = null;
    while (root != null) {
      if (root.left == null) {
        if (last != null && root.val <= last.val) {
          return false;
        }
        last = root;
        root = root.right;
      } else {
        TreeNode pre = root.left;
        while (pre.right != null && pre.right != root) {
          pre = pre.right;
        }
        if (pre.right == null) {
          pre.right = root;
          root = root.left;
        }
        if (pre.right == root) {
          if (last != null && root.val <= last.val) {
            return false;
          }
          last = root;
          root = root.right;
        }
      }
    }
    return true;
  }

    public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }
    if (min != null && root.val <= min) {
      return false;
    }
    if (max != null && root.val >= max) {
      return false;
    }
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }


  /**
   * Runtime: 37 ms, faster than 7.31% of Java online submissions for Validate Binary Search Tree.
   * Memory Usage: 39.3 MB, less than 80.47% of Java online submissions for Validate Binary Search Tree.
   */
  public boolean isValidBSTByInOrder(TreeNode root) {
    if (root == null) {
      return true;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        System.out.println(pop.val);
        if (pre != null && pop.val <= pre.val) {
          return false;
        } else {
          pre = pop;
        }
        root = pop.right;
      }
    }
    return true;
  }


    public boolean isValidBST1(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    if (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode poll = queue.poll();
        if (poll.left != null && poll.left.val <= poll.val) {
          queue.offer(poll.left);
        } else {
          return false;
        }
        if (poll.right != null && poll.right.val >= poll.val) {
          queue.offer(poll.right);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{5, 1});
    System.out.println(binaryTree);
    binaryTree.getRoot().right = new TreeNode(4);
    binaryTree.getRoot().right.left = new TreeNode(3);
    binaryTree.getRoot().right.right = new TreeNode(6);
    S_98ValidateBinarySearchTree validateBinarySearchTree = new S_98ValidateBinarySearchTree();
    System.out.println(validateBinarySearchTree.isValidBSTByMorris(binaryTree.getRoot()));

  }

}

package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 */
public class S_144BinaryTreePreorderTraversal {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    while (root != null) {
      if (root.left == null) {
        result.add(root.val);
        root = root.right;
      } else {
        TreeNode pre = root.left;
        while (pre.right != null && pre.right != root) {
          pre = pre.right;
        }
        if (pre.right == null) {
          result.add(root.val);
          pre.right = root;
          root = root.left;
        }
        if (pre.right == root) {
          pre.right = null;
          root = root.right;
        }
      }
    }

    return result;
  }



    public List<Integer> preorderTraversalByIterator(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        result.add(root.val);
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        root = pop.right;
      }
    }
    return result;
  }

  public List<Integer> preorderTraversalByRecursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preorderTraversal(root, result);
    return result;
  }

  private void preorderTraversal(TreeNode root, List<Integer> result) {
    if (root != null) {
      result.add(root.val);
      preorderTraversal(root.left, result);
      preorderTraversal(root.right, result);
    }
  }


  public static void main(String[] args) {

  }
}

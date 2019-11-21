package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 */
public class S_94BinaryTreeInorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
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
          pre.right = root;
          root = root.left;
        }
        if (pre.right == root) {
          pre.right = null;
          result.add(root.val);
          root = root.right;
        }
      }
    }
    return result;
  }


    public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        result.add(pop.val);
        root = pop.right;
      }
    }
    return result;
  }

  public List<Integer> inorderTraversalByRecursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraversalByRecursive(root, result);
    return result;
  }

  private void inorderTraversalByRecursive(TreeNode root, List<Integer> result) {
    if (root != null) {
      inorderTraversalByRecursive(root.left, result);
      result.add(root.val);
      inorderTraversalByRecursive(root.right, result);
    }
  }


  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3});

    S_94BinaryTreeInorderTraversal binaryTreeInorderTraversal = new S_94BinaryTreeInorderTraversal();
    System.out.println(binaryTreeInorderTraversal.inorderTraversal(binaryTree.getRoot()));
    System.out.println(binaryTree);
  }
}

package com.tobias.rudiment.trie;


import java.util.Stack;

public class BinaryTree {

  private TreeNode root;
  private int size;

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

  }

  public BinaryTree() {
    root = null;
  }

  public BinaryTree(int[] array) {
    for (int i : array) {
      add(i);
    }
  }

  public void add(int value) {
    root = add(value, root);
  }


  private TreeNode add(int value, TreeNode node) {
    if (node == null) {
      size++;
      return new TreeNode(value);
    }

    if (value <= node.val) {
      node.left = add(value, node.left);
    } else {
      node.right = add(value, node.right);
    }
    return node;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
//    midOrderTraversalByIterator(root, sb);
    return sb.toString();
  }


  public String print() {
    StringBuilder sb = new StringBuilder();
    preOrderTraversalByRecursive(root, sb);
    return sb.toString();
  }

  private void preOrderTraversalByIterator(TreeNode root, StringBuilder sb) {
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        sb.append(root.val).append(" -> ");
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        root = pop.right;

      }
    }

  }

  private void midOrderTraversalByIterator (TreeNode root, StringBuilder sb) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        sb.append(pop.val).append(" -> ");
        root = pop.right;
      }
    }
  }

  private void preOrderTraversalByRecursive(TreeNode node, StringBuilder sb) {
    if (node != null) {
      preOrderTraversalByRecursive(node.left, sb);
      preOrderTraversalByRecursive(node.right, sb);
      sb.append(node.val).append(" -> ");
    }
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3});

    System.out.println(binaryTree.print());
  }
}

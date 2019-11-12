package com.tobias.rudiment.trie;


import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

  private TreeNode root;
  private int size;

  public static class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    int level;

    public TreeNode(int x) {
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

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
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

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    levelTraversal(root, sb);
    return sb.toString();
  }


  private void levelTraversal(TreeNode root, StringBuilder sb) {
    if (root != null) {
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        root = queue.pollFirst();
        sb.append(root.val).append(" -> ");
        if (root.left != null) {
          queue.add(root.left);
        }
        if (root.right != null) {
          queue.add(root.right);
        }
      }
    }
  }

  private void postOrderTraversalByIterator(TreeNode root, StringBuilder sb) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode last = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode peek = stack.peek();
        if (peek.right != null && peek.right != last) {
          root = peek.right;
        } else {
          peek = stack.pop();
          sb.append(peek.val).append(" -> ");
          last = peek;
        }
      }
    }
  }


  private void midOrderTraversalByIterator(TreeNode root, StringBuilder sb) {
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


  private void preOrderTraversalByRecursive(TreeNode node, StringBuilder sb) {
    if (node != null) {
      preOrderTraversalByRecursive(node.left, sb);
      preOrderTraversalByRecursive(node.right, sb);
      sb.append(node.val).append(" -> ");
    }
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3});
    System.out.println(binaryTree);
  }
}

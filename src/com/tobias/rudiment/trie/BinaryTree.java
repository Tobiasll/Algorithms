package com.tobias.rudiment.trie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

  }

  public BinaryTree(TreeNode root) {
    this.root = root;
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
    return handleLevelTraversalList(levelTraversal(root));
  }

  private String handleLevelTraversalList(List<StringBuilder> list) {
    if (list.isEmpty()) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    for (int i = list.size() - 2, blank = 2; i >= 0; i--, blank = 2 + (2 * blank)) {
      StringBuilder sb = list.get(i);
      char[] blankChars = new char[blank];
      Arrays.fill(blankChars, ' ');
      String blankString = String.valueOf(blankChars);

      int j = 0;
      while (sb.charAt(j) != '\n') {
        if (sb.charAt(j) != ' ') {
          sb.insert(j, blankString);
          j += blank + 1;
        } else {
          j++;
        }
      }

    }
    for (StringBuilder sb : list) {
      result.append(sb);
    }
    return result.toString();
  }

  private List<StringBuilder> levelTraversal(TreeNode root) {
    List<StringBuilder> list = new ArrayList<>();
    if (root != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        int queueSize = queue.size();
        boolean isAllNull = true;
        for (int i = 0; i < queueSize; i++) {
          root = queue.poll();
          if (root.val != Integer.MIN_VALUE) {
            sb.append(root.val);
          } else {
            sb.append('n');
          }
          if (i != queueSize - 1) {
            sb.append(" - ");
          }
          if (root.left != null) {
            isAllNull = false;
            queue.add(root.left);
          } else {
            queue.offer(new TreeNode(Integer.MIN_VALUE));
          }
          if (root.right != null) {
            isAllNull = false;
            queue.add(root.right);
          } else {
            queue.offer(new TreeNode(Integer.MIN_VALUE));
          }

        }
        sb.append("\n");
        list.add(sb);
        if (isAllNull) {
          break;
        }
      }
    }
    return list;
  }

  public static void addLeftAndRightNodeToQueue(Queue<TreeNode> tempQueue, TreeNode pollNode) {
    if (pollNode.left != null) {
      tempQueue.add(pollNode.left);
    }
    if (pollNode.right != null) {
      tempQueue.add(pollNode.right);
    }
  }

  public static void offerLeftAndRightNodeToQueue(Queue<TreeNode> queue, TreeNode pollNode) {
    if (pollNode != null) {
      if (pollNode.left != null) {
        queue.offer(pollNode.left);
      }
      if (pollNode.right != null) {
        queue.offer(pollNode.right);
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

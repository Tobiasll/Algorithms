package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class S_103BinaryTreeZigzagLevelOrderTraversal {


  private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    int level = 0;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        if (result.size() <= level) {
          result.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
          result.get(level++).add(root.val);
        } else {
          result.get(level++).add(0, root.val);
        }
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
          level--;

        root = pop.right;
      }
    }
    return result;
  }

    public List<List<Integer>> zigzagLevelOrderByRecursiveDFS(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    zigzagLevelOrderByRecursiveDFS(root, 0, result);
    return result;
  }

  private void zigzagLevelOrderByRecursiveDFS(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) {
      return;
    }
    if (result.size() <= level) {
      result.add(new ArrayList<>());
    }
    if (level % 2 == 0) {
      result.get(level).add(root.val);
    } else {
      result.get(level).add(0, root.val);
    }
    zigzagLevelOrderByRecursiveDFS(root.left, level + 1, result);
    zigzagLevelOrderByRecursiveDFS(root.right, level + 1, result);
  }

  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    boolean getValueFromStack = false;
    queue.offer(root);

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      List<Integer> insideList = new ArrayList<>();
      for (int i = 0; i < queueSize; i++) {
        TreeNode treeNode = queue.poll();
        if (getValueFromStack) {
          insideList.add(0, treeNode.val);
        } else {
          insideList.add(treeNode.val);
        }
        if (treeNode.left != null) {
          queue.offer(treeNode.left);
        }
        if (treeNode.right != null) {
          queue.offer(treeNode.right);
        }
      }
      result.add(insideList);
      getValueFromStack = !getValueFromStack;
    }

    return result;
  }

  public List<List<Integer>> zigzagLevelOrderByBFS(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null){
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      List<Integer> insideList = new ArrayList<>();
      for (int i = 0; i < queueSize; i++) {
        TreeNode poll = queue.poll();
          insideList.add(poll.val);
          if (poll.left != null) {
            queue.offer(poll.left);
          }
          if (poll.right != null) {
            queue.offer(poll.right);
          }
      }
      result.add(insideList);
    }
    for (int i = 0; i < result.size(); i++) {
      if (i % 2 != 0) {
        for (int start = 0, end = result.get(i).size() - 1; start <= end; start++, end--) {
          Integer temp = result.get(i).get(start);
          result.get(i).set(start, result.get(i).get(end));
          result.get(i).set(end, temp);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{1, 3});
    binaryTree.getRoot().left = new TreeNode(2);
    binaryTree.getRoot().left.left = new TreeNode(4);
    binaryTree.getRoot().left.right = new TreeNode(5);
//    binaryTree.getRoot().left.left.left = new TreeNode(4);
//    binaryTree.getRoot().left.left.left.left = new TreeNode(5);
    System.out.println(binaryTree);
    S_103BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new S_103BinaryTreeZigzagLevelOrderTraversal();
    List<List<Integer>> results = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder2(binaryTree.getRoot());
    for (List<Integer> result : results) {
      System.out.println(result);
    }
  }

}

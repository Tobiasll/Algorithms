package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class S_113PathSumII {

  public List<List<Integer>> pathSumByDFS(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    int pathSum = 0;
    TreeNode lastNode = null;
    Stack<Integer> insideLitStack = new Stack<>();
    while (root != null ||!stack.isEmpty()) {
      if (root != null) {
        pathSum += root.val;
        insideLitStack.push(root.val);
        stack.push(root);
        root = root.left;
      } else {
        TreeNode peek = stack.peek();
        if (peek.left == null && peek.right == null && sum == pathSum) {
          result.add(new ArrayList<>(insideLitStack));
        }
        if (peek.right != null && peek.right != lastNode) {
          root = peek.right;
        } else {
          TreeNode popNode = stack.pop();
          insideLitStack.pop();
          pathSum -= popNode.val;
          lastNode = popNode;
        }
      }
    }
    return result;
  }


  public List<List<Integer>> pathSumByBFS(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> queueNum = new LinkedList<>();
    queue.offer(root);
    queueNum.offer(root.val);
    List<Integer> insideList = new ArrayList<>();
    insideList.add(root.val);
    Queue<List<Integer>> queueList = new LinkedList<>();
    queueList.offer(insideList);
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode pollNode = queue.poll();
        Integer lastValue = queueNum.poll();
        List<Integer> list = queueList.poll();
        if (pollNode.left == null && pollNode.right == null && lastValue == sum) {
          result.add(list);
        }
        if (pollNode.left != null) {
          queue.offer(pollNode.left);
          queueNum.offer(lastValue + pollNode.left.val);
          List<Integer> tempList = new ArrayList<>(list);
          tempList.add(pollNode.left.val);
          queueList.offer(tempList);
        }
        if (pollNode.right != null) {
          queue.offer(pollNode.right);
          queueNum.offer(lastValue + pollNode.right.val);
          List<Integer> tempList = new ArrayList<>(list);
          tempList.add(pollNode.right.val);
          queueList.offer(tempList);
        }
      }
    }
    return result;
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    pathSum(root, sum, result, new ArrayList<>());
    return result;
  }

  private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tempList) {
    if (root.left == null && root.right == null) {
      if (sum == root.val) {
        List<Integer> insideList = new ArrayList<>(tempList);
        insideList.add(root.val);
        result.add(insideList);
      }
      return;
    }

    if (root.left == null) {
      tempList.add(root.val);
      pathSum(root.right, sum - root.val, result, tempList);
      tempList.remove(tempList.size() - 1);
      return;
    }
    if (root.right == null) {
      tempList.add(root.val);
      pathSum(root.left, sum - root.val, result, tempList);
      tempList.remove(tempList.size() - 1);
      return;
    }
    tempList.add(root.val);
    pathSum(root.left, sum - root.val, result, tempList);
    tempList.remove(tempList.size() - 1);
    tempList.add(root.val);
    pathSum(root.right, sum - root.val, result, tempList);
    tempList.remove(tempList.size() - 1);
  }


  public static void main(String[] args) {
    BinaryTree binaryTree = buildBinaryTree();
    binaryTree.getRoot().right.right.left = new TreeNode(5);
    System.out.println(binaryTree);
    S_113PathSumII pathSumII = new S_113PathSumII();
    List<List<Integer>> list = pathSumII.pathSumByDFS(binaryTree.getRoot(), 22);
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }
  }

  static BinaryTree buildBinaryTree() {
    BinaryTree binaryTree = new BinaryTree(new int[]{5,4,8});
    binaryTree.getRoot().left.left = new TreeNode(11);
    binaryTree.getRoot().right.left = new TreeNode(13);
    binaryTree.getRoot().right.right = new TreeNode(4);
    binaryTree.getRoot().left.left.left = new TreeNode(7);
    binaryTree.getRoot().left.left.right = new TreeNode(2);
    binaryTree.getRoot().right.right.right = new TreeNode(1);
    return binaryTree;
  }
}

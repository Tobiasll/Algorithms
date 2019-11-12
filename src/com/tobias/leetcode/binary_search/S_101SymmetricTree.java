package com.tobias.leetcode.binary_search;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class S_101SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> leftQueue = new LinkedList<>();
    Queue<TreeNode> rightQueue = new LinkedList<>();
    leftQueue.offer(root.left);
    rightQueue.offer(root.right);

    while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
      TreeNode leftRoot = leftQueue.poll();
      TreeNode rightRoot = rightQueue.poll();
      if (leftRoot == null && rightRoot != null || leftRoot != null && rightRoot == null) {
        return false;
      }
      if (leftRoot != null && rightRoot != null) {
        if (leftRoot.val != rightRoot.val) {
          return false;
        }
        leftQueue.offer(leftRoot.left);
        rightQueue.offer(rightRoot.right);

        leftQueue.offer(leftRoot.right);
        rightQueue.offer(rightRoot.left);
      }
    }
    return true;
  }


    /**
     * Runtime: 1 ms, faster than 47.43% of Java online submissions for Symmetric Tree.
     * Memory Usage: 39.4 MB, less than 31.97% of Java online submissions for Symmetric Tree.
     */
  public boolean isSymmetricByDFS(TreeNode root) {
    if (root == null) {
      return true;
    }
    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();
    TreeNode leftRoot = root.left;
    TreeNode rightRoot = root.right;

    while (leftRoot != null || rightRoot != null || !leftStack.isEmpty() || !rightStack.isEmpty()) {
      while (leftRoot != null) {
        leftStack.push(leftRoot);
        leftRoot = leftRoot.left;
      }

      while (rightRoot != null) {
        rightStack.push(rightRoot);
        rightRoot = rightRoot.right;
      }

      if (leftStack.size() != rightStack.size()) {
        return false;
      }

      leftRoot = leftStack.pop();
      rightRoot = rightStack.pop();

      if (leftRoot.val != rightRoot.val) {
        return false;
      }

      leftRoot = leftRoot.right;
      rightRoot = rightRoot.left;
    }
    return true;
  }

  public boolean isSymmetricByRecursive(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right != null || left != null && right == null) {
      return false;
    }
    if (left == null && right == null) {
      return true;
    }
    return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }

  public boolean isSymmetricByBFS1(TreeNode root) {
    if (root != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        int queueSize = queue.size();

        for (int i = 0; i < queueSize; i++) {
          TreeNode pollNode = queue.poll();
          if (pollNode != null) {
            if (pollNode.left != null) {
              list.add(pollNode.left.val);
              queue.offer(pollNode.left);
            } else {
              list.add(-1);
            }
            if (pollNode.right != null) {
              list.add(pollNode.right.val);
              queue.offer(pollNode.right);
            } else {
              list.add(-1);
            }

          }
        }
        System.out.println(list);
        if (!judge(list)) {
          return false;
        }
      }
    }
    return true;
  }


  public boolean judge(List<Integer> list) {
    for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
      if (!list.get(i).equals(list.get(j))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(2);
    root1.left.left = new TreeNode(3);
    root1.left.right = new TreeNode(4);
    root1.right.left = new TreeNode(4);
    root1.right.right = new TreeNode(3);
    BinaryTree binaryTree = new BinaryTree(root1);
    System.out.println(binaryTree);
    S_101SymmetricTree symmetricTree = new S_101SymmetricTree();
    System.out.println(symmetricTree.isSymmetric(root1));

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(2);
    root2.left.right = new TreeNode(3);
    root2.right.right = new TreeNode(3);
    System.out.println(symmetricTree.isSymmetric(root2));
  }
}

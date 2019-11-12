package com.tobias.leetcode.binary_search;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class S_104MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    int level = 0;
    if (root == null) {
      return level;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelNum = queue.size();
      for (int i = 0; i < levelNum; i++) {
        TreeNode pollNode = queue.poll();
        BinaryTree.offerLeftAndRightNodeToQueue(queue, pollNode);
      }
      level++;
    }
    return level;
  }



  public int maxDepth1(TreeNode root) {
    int count = 0;
    if (root != null) {
      LinkedList<TreeNode> queue = new LinkedList<>();
      LinkedList<TreeNode> tempQueue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        TreeNode pollNode = queue.pollFirst();
        BinaryTree.addLeftAndRightNodeToQueue(tempQueue, pollNode);
        if (queue.isEmpty()) {
          count++;
          queue.addAll(tempQueue);
          tempQueue.clear();
        }
      }

    }
    return count;
  }




  public int maxDepthByRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepthByRecursive(root.left), maxDepthByRecursive(root.right)) + 1;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{3,20});
    TreeNode root = binaryTree.getRoot();
    root.left = new TreeNode(9);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
//    S_104MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new S_104MaximumDepthOfBinaryTree();
//    System.out.println(maximumDepthOfBinaryTree.maxDepth(root));
    S_107BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new S_107BinaryTreeLevelOrderTraversalII();
    binaryTreeLevelOrderTraversalII.levelOrderBottom(root).forEach(System.out::println);
    binaryTree.setRoot(root);
    System.out.println(binaryTree);
  }

}

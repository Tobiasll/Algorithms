package com.tobias.leetcode.binary_search;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//            queue.offer(Objects.requireNonNullElseGet(pollNode.left, () -> new TreeNode(-1)));
//            queue.offer(Objects.requireNonNullElseGet(pollNode.right, () -> new TreeNode(-1)));
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

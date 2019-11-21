package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.Stack;

/**
 *Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class S_114FlattenBinaryTreeToLinkedList {

  private TreeNode pre;

  public TreeNode flatten(TreeNode root1) {
    TreeNode root = root1;
    if (root == null) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode pop = stack.pop();
      if (root != null && root != pop) {
        root.right = pop;
        root.left = null;
        root = root.right;
      } else {
        root = pop;
      }
      if (pop.right != null) {
        stack.push(pop.right);
      }
      if (pop.left != null) {
        stack.push(pop.left);
      }
    }
    return root1;
  }

    public TreeNode flatten2(TreeNode root1) {
    TreeNode root = root1;
    if (root == null) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode last = null;

    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.right;
      } else {
        TreeNode peek = stack.peek();
        if (peek.left != null && peek.left != last) {
          root = peek.left;
        } else {
          TreeNode pop = stack.pop();
          peek.right = last;
          peek.left = null;
          last = peek;
        }
      }
    }
    return root1;
  }



  public void flattenByRecursive(TreeNode root) {
    if (root == null) {
      return;
    }
    flattenByRecursive(root.right);
    flattenByRecursive(root.left);
    root.right = pre;
    root.left = null;
    pre = root;
  }

  public TreeNode flatten1(TreeNode root) {
    TreeNode currentRoot = root;

    while (currentRoot != null) {
      if (currentRoot.left != null) {
        TreeNode pre = currentRoot.left;
        while (pre.right != null) {
          pre = pre.right;
        }
        pre.right = currentRoot.right;
        currentRoot.right = currentRoot.left;
        currentRoot.left = null;
      }
      currentRoot = currentRoot.right;
    }
    return root;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{1, 5, 6});
    binaryTree.getRoot().left = new TreeNode(2);
    binaryTree.getRoot().left.left = new TreeNode(3);
    binaryTree.getRoot().left.right = new TreeNode(4);
    System.out.println(binaryTree);
    S_114FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new S_114FlattenBinaryTreeToLinkedList();
    flattenBinaryTreeToLinkedList.flatten(binaryTree.getRoot());

    System.out.println(binaryTree);
  }

}

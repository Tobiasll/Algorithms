package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

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

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten1(root.right);
    flatten1(root.left);
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

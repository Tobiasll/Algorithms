package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class S_105ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> memo = new HashMap<>(inorder.length + 1);
    for (int i = 0; i < inorder.length; i++) {
      memo.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, memo);
  }

  private TreeNode buildTreeHelper(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd, Map<Integer, Integer> map) {
    if (pStart == pEnd) {
      return null;
    }
    int pValue = preOrder[pStart];
    TreeNode root = new TreeNode(pValue);
    int iRootIndex = map.get(pValue);
    int leftNum = iRootIndex - iStart;
    root.left = buildTreeHelper(preOrder, pStart + 1, pStart + leftNum + 1, inOrder, iStart, iRootIndex, map);
    root.right = buildTreeHelper(preOrder, pStart + leftNum + 1, pEnd, inOrder, iRootIndex + 1, iEnd, map);

    return root;
  }

  public static void main(String[] args) {
    S_105ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new S_105ConstructBinaryTreeFromPreorderAndInorderTraversal();
    BinaryTree binaryTree = new BinaryTree(constructBinaryTreeFromPreorderAndInorderTraversal
        .buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    System.out.println(binaryTree);
  }

}

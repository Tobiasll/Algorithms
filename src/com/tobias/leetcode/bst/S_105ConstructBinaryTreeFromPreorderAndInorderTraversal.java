package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
    if (preorder.length == 0) {
      return null;
    }
    Stack<TreeNode> roots = new Stack<>();
    int pre = 0;
    int in = 0;
    //先序遍历第一个值作为根节点
    TreeNode curRoot = new TreeNode(preorder[pre]);
    TreeNode root = curRoot;
    roots.push(curRoot);
    pre++;
    //遍历前序遍历的数组
    while (pre < preorder.length) {
      //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
      if (curRoot.val == inorder[in]) {
        //每次进行出栈，实现倒着遍历
        while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
          curRoot = roots.peek();
          roots.pop();
          in++;
        }
        //设为当前的右孩子
        curRoot.right = new TreeNode(preorder[pre]);
        //更新 curRoot
        curRoot = curRoot.right;
        roots.push(curRoot);
        pre++;
      } else {
        //否则的话就一直作为左子树
        curRoot.left = new TreeNode(preorder[pre]);
        curRoot = curRoot.left;
        roots.push(curRoot);
        pre++;
      }
    }
    return root;
  }


  public TreeNode buildTree2(int[] preorder, int[] inorder) {
    return buildTreeHelper(preorder, inorder, Integer.MAX_VALUE);
  }
  private int pre;
  private int in;
  private TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, int stop) {
    if (pre == preOrder.length) {
      return null;
    }
    if (inOrder[in] == stop) {
      in++;
      return null;
    }
    int rootValue = preOrder[pre++];
    TreeNode root = new TreeNode(rootValue);
    root.left = buildTreeHelper(preOrder, inOrder, rootValue);
    root.right = buildTreeHelper(preOrder, inOrder, stop);
    return root;
  }


  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    Map<Integer, Integer> memo = new HashMap<>(inorder.length + 1);
    for (int i = 0; i < inorder.length; i++) {
      memo.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, preorder.length,  0, memo);
  }

  private TreeNode buildTreeHelper(int[] preOrder, int pStart, int pEnd,  int iStart,  Map<Integer, Integer> map) {
    if (pStart == pEnd) {
      return null;
    }
    int pValue = preOrder[pStart];
    TreeNode root = new TreeNode(pValue);
    int iRootIndex = map.get(pValue);
    int leftNum = iRootIndex - iStart;
    root.left = buildTreeHelper(preOrder, pStart + 1, pStart + leftNum + 1, iStart, map);
    root.right = buildTreeHelper(preOrder, pStart + leftNum + 1, pEnd, iRootIndex + 1, map);
    return root;
  }

  public static void main(String[] args) {
    S_105ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new S_105ConstructBinaryTreeFromPreorderAndInorderTraversal();
    BinaryTree binaryTree = new BinaryTree(constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    System.out.println(binaryTree);
  }

}

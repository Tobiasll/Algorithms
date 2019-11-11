package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class S_100SameTree {


  public boolean isSameTree(TreeNode p, TreeNode q) {
    Stack<TreeNode> stackP = new Stack<>();
    Stack<TreeNode> stackQ = new Stack<>();
    while (p != null && q != null || !stackP.isEmpty() && !stackQ.isEmpty()) {
      if (p != null && q != null) {
        if (p.val != q.val) {
          return false;
        }
        stackP.push(p);
        stackQ.push(q);
        p = p.left;
        q = q.left;
      } else if((q == null && p != null) || (q != null && p == null)){
        return false;
      }else {
        TreeNode popP = stackP.pop();
        TreeNode popQ = stackQ.pop();
        p = popP.right;
        q = popQ.right;
      }
    }
    return (q == null || p != null) && (q != null || p == null);
  }


  public boolean isSameTreeByRecursive(TreeNode p, TreeNode q) {
    return judge(p, q);
  }

  public boolean judge(TreeNode p, TreeNode q) {
    if (p != null && q != null) {
      if (p.val == q.val) {
        boolean resultLeft = judge(p.left, q.left);
        if (!resultLeft) {
          return resultLeft;
        }
        boolean resultRight = judge(p.right, q.right);
        if (!resultRight) {
          return resultRight;
        }
        return true;
      } else {
        return false;
      }
    } else
      return (q == null || p != null) && (q != null || p == null);
  }


  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{2});
    TreeNode rootA = binaryTree.getRoot();
//    rootA.left = new TreeNode(2);
    rootA.right = new TreeNode(4);
    S_100SameTree sameTree = new S_100SameTree();
    TreeNode rootB = new TreeNode(2);
    rootB.left = new TreeNode(3);
    rootB.right = new TreeNode(4);
    System.out.println(sameTree.isSameTree(rootA, rootB));
    binaryTree.setRoot(rootA);
    System.out.println(binaryTree);
    binaryTree.setRoot(rootB);
    System.out.println(binaryTree);
  }
}

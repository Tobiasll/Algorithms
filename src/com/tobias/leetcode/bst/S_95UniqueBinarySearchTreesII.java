package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class S_95UniqueBinarySearchTreesII {


  public List<TreeNode> generateTrees(int n) {
    ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
    dp[0] = new ArrayList<>();
    if (n == 0) {
      return dp[0];
    }
    dp[0].add(null);

    for (int i = 1; i <= n; i++) {
      dp[i] = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        ArrayList<TreeNode> leftTrees = dp[j - 1];
        ArrayList<TreeNode> rightTrees = dp[i - j];
        for (TreeNode leftTree : leftTrees) {
          for (TreeNode rightTree : rightTrees) {

            TreeNode treeNode = new TreeNode(j);
            treeNode.left = leftTree;
            treeNode.right = clone(rightTree, j);
            dp[i].add(treeNode);
          }
        }
      }
    }
    return dp[n];
  }

  private TreeNode clone(TreeNode root, int j) {
    if (root == null) {
      return null;
    }
    TreeNode treeNode = new TreeNode(root.val + j);
    treeNode.left = clone(root.left, j);
    treeNode.right = clone(root.right, j);
    return treeNode;
  }

  public List<TreeNode> generateTreesByRecursive(int n) {
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    if (start == end) {
      TreeNode treeNode = new TreeNode(start);
      result.add(treeNode);
      return result;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTree = generateTrees(start, i - 1);
      List<TreeNode> rightTree = generateTrees(i + 1, end);
      for (TreeNode left : leftTree) {
        for (TreeNode right : rightTree) {
          TreeNode treeNode = new TreeNode(i);
          treeNode.left = left;
          treeNode.right = right;
          result.add(treeNode);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    S_95UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new S_95UniqueBinarySearchTreesII();
    List<TreeNode> treeNodes = uniqueBinarySearchTreesII.generateTrees(20);
    for (TreeNode root : treeNodes) {
      System.out.println(new BinaryTree(root));
    }
  }
}

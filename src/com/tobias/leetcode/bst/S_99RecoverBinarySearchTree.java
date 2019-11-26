package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
@SuppressWarnings("all")
public class S_99RecoverBinarySearchTree {

  private TreeNode first;
  private TreeNode second;
  private TreeNode pre;


  public void recoverTreeInOrderTraversalByRecursive(TreeNode root) {
//    inOrderTraversalByRecursive(root);
//    inOrderTraversalByIterator(root);
    inOrderTraversalByMorris(root);
    if (first != null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }

  private void inOrderTraversalByMorris (TreeNode root) {
    while (root != null) {
      if (root.left == null) {
        if (pre != null && pre.val > root.val) {
          if (first == null) {
            first = pre;
            second = root;
          } else {
            second = root;
          }
        }
        pre = root;
        root = root.right;
      } else {
        TreeNode last = root.left;
        while (last.right != null && last.right != root) {
          last = last.right;
        }
        if (last.right == null) {
          last.right = root;
          root = root.left;
        }
        if (last.right == root) {
          last.right = null;
          if (pre != null && pre.val > root.val) {
            if (first == null) {
              first = pre;
              second = root;
            } else {
              second = root;
            }
          }
          pre = root;
          root = root.right;
        }
      }
    }
  }

  private void inOrderTraversalByIterator (TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        if (pre != null && pre.val > pop.val) {
          if (first == null) {
            first = pre;
            second = pop;
          } else {
            second = pop;
          }
        }
        pre = pop;
        root = pop.right;
      }
      byte[] bytes = new byte[1024];
      String s = new String(bytes);
    }
  }


  private void inOrderTraversalByRecursive (TreeNode root) {
    if (root == null) {
      return;
    }
    inOrderTraversalByRecursive(root.left);
    if (pre != null && pre.val > root.val) {
      if (first == null) {
        first = pre;
        second = root;
      } else {
        second = root;
      }
    }
    pre = root;
    inOrderTraversalByRecursive(root.right);
  }

  public void recoverTreeByRecursive (TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode leftMaxNode = getMaxNode(root.left);
    TreeNode rightMaxNode = getMinNode(root.right);

    if (leftMaxNode != null && rightMaxNode != null) {
      if (leftMaxNode.val > root.val && rightMaxNode.val < root.val) {
        int temp = leftMaxNode.val;
        leftMaxNode.val = rightMaxNode.val;
        rightMaxNode.val = temp;
      }
    }
    if (leftMaxNode != null) {
      if (leftMaxNode.val > root.val) {
        int temp = leftMaxNode.val;
        leftMaxNode.val = root.val;
        root.val = temp;
      }
    }

    if (rightMaxNode != null) {
      if (rightMaxNode.val < root.val) {
        int temp = rightMaxNode.val;
        rightMaxNode.val = root.val;
        root.val = temp;
      }
    }

    recoverTreeByRecursive(root.left);
    recoverTreeByRecursive(root.right);
  }


  private TreeNode getMinNode (TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftMinNode = getMinNode(root.left);
    TreeNode rightMinNode = getMinNode(root.right);
    TreeNode min = root;
    if (leftMinNode != null && leftMinNode.val < min.val) {
      min = leftMinNode;
    }
    if (rightMinNode != null && rightMinNode.val < min.val) {
      min = rightMinNode;
    }
    return min;
  }

  private TreeNode getMaxNode (TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftMaxNode = getMaxNode(root.left);
    TreeNode rightMaxNode = getMaxNode(root.right);
    TreeNode max = root;

    if (leftMaxNode != null && leftMaxNode.val > max.val) {
      max = leftMaxNode;
    }
    if (rightMaxNode != null && rightMaxNode.val > max.val) {
      max = rightMaxNode;
    }
    return max;
  }


  public static void main(String[] args) {

    BinaryTree binaryTree = new BinaryTree(new int[]{3, 1 ,4});
    binaryTree.getRoot().right.left = new TreeNode(2);
    System.out.println(binaryTree);
    S_99RecoverBinarySearchTree recoverBinarySearchTree = new S_99RecoverBinarySearchTree();
    recoverBinarySearchTree.recoverTreeInOrderTraversalByRecursive(binaryTree.getRoot());
    System.out.println(binaryTree);
  }
}

package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.Stack;


/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class S_108ConvertSortedArrayToBinarySearchTree {


  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    int start = 0;
    int end = nums.length;
    int mid = (start + end) >>> 1;
    TreeNode root = new TreeNode(nums[mid]);
    TreeNode curRoot = root;
    Stack<MyTreeNode> stack = new Stack<>();
    stack.push(new MyTreeNode(curRoot, start, end));
    while (end - start > 1 || !stack.isEmpty()) {
      while (end - start > 1) {
        end = mid;
        mid = (start + end) >>> 1;
        curRoot.left = new TreeNode(nums[mid]);
        curRoot = curRoot.left;
        stack.push(new MyTreeNode(curRoot, start, end));
      }
      MyTreeNode pop = stack.pop();
      end = pop.end;
      mid = (end + pop.start) >>> 1;
      start = mid + 1;
      if (start < end) {
        mid = (end + start) >>> 1;
        curRoot = pop.root;
        curRoot.right = new TreeNode(nums[mid]);
        curRoot = curRoot.right;
        stack.push(new MyTreeNode(curRoot, start, end));
      }

    }
    return root;
  }

  class MyTreeNode {
      TreeNode root;
      int start;
      int end;

    MyTreeNode(TreeNode root, int start, int end) {
      this.root = root;
      this.start = start;
      this.end = end;
    }
  }

    public TreeNode sortedArrayToBST1(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length);
  }

  private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (start == end) {
      return null;
    }
    int mid = (start + end) >>> 1;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, start, mid);
    root.right = sortedArrayToBST(nums, mid + 1, end);

    return root;
  }



  public static void main(String[] args) {
    S_108ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new S_108ConvertSortedArrayToBinarySearchTree();
    System.out.println(new BinaryTree(convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-10,-3,0,5,9})));
    System.out.println(new BinaryTree(convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-1, 0, 1, 2})));
    System.out.println(new BinaryTree(convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{0,1,2,3,4,5})));
  }

}
